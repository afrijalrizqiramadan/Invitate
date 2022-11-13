package com.asyabab.fastechqr.activity

import android.Manifest
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.asyabab.fastechqr.R
import com.asyabab.fastechqr.base.DPBaseActivity
import com.asyabab.fastechqr.data.local.SharedPrefHelper
import com.asyabab.fastechqr.data.models.general.GeneralResponse
import com.budiyev.android.codescanner.*
import com.karumi.dexter.Dexter
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionDeniedResponse
import com.karumi.dexter.listener.PermissionGrantedResponse
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.single.PermissionListener
import kotlinx.android.synthetic.main.alertlayout.view.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class PindaiKeluarActivity : DPBaseActivity() {
    private lateinit var codeScanner: CodeScanner
    var idundangan=""

    //    var url = "http://10.10.10.100/fastech/android/kirimkeluar.php?id_undangan="
    var url = ""
    var urlket = ""
    var urlget = ""
    var host = "http://"
    private var requestQueue: RequestQueue? = null
    private var stringRequest: StringRequest? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_keluarpindai)
        val sharedPreference: SharedPrefHelper = SharedPrefHelper(this)

        if (sharedPreference.getString("url")!=null) {
            host+=sharedPreference.getString("url")!!
            Toast.makeText(this@PindaiKeluarActivity,"Sukses Host : "+host,Toast.LENGTH_SHORT).show()
        }
        val scannerView = findViewById<CodeScannerView>(R.id.scanner_view)

        codeScanner = CodeScanner(this, scannerView)
         url = host+"/server/android/kirimkeluar.php?id_undangan="
         urlket = host+"/server/android/kirimjumlah.php?id_undangan="
         urlget = host+"/server/android/getdata.php?id="
        codeScanner.camera = CodeScanner.CAMERA_FRONT // or CAMERA_FRONT or specific camera id
        codeScanner.formats = CodeScanner.TWO_DIMENSIONAL_FORMATS // list of type BarcodeFormat,
        codeScanner.autoFocusMode = AutoFocusMode.CONTINUOUS // or CONTINUOUS
        codeScanner.scanMode = ScanMode.SINGLE // or CONTINUOUS or PREVIEW
        codeScanner.isAutoFocusEnabled = true // Whether to enable auto focus or not
        codeScanner.isFlashEnabled = false // Whether to enable flash or not

        codeScanner.decodeCallback = DecodeCallback {
            runOnUiThread {
                idundangan="${it.text}"
                sendnama(idundangan)

            }
        }
        codeScanner.errorCallback = ErrorCallback { // or ErrorCallback.SUPPRESS
            runOnUiThread {
                Toast.makeText(this, "Camera initialization error: ${it.message}",
                    Toast.LENGTH_LONG).show()
            }
        }

        scannerView.setOnClickListener {
            codeScanner.startPreview()
        }
        //        tvkamar.setText(skamar);
        requestQueue = Volley.newRequestQueue(this)

    }

    override fun onResume() {
        super.onResume()
        checkCameraPermission()
        codeScanner.startPreview()
    }

    override fun onPause() {
        codeScanner.releaseResources()
        super.onPause()
    }

    private fun checkCameraPermission() {
        Dexter.withActivity(this)
            .withPermission(Manifest.permission.CAMERA)
            .withListener(object : PermissionListener {
                override fun onPermissionGranted(response: PermissionGrantedResponse) {
                    codeScanner!!.startPreview()
                }

                override fun onPermissionDenied(response: PermissionDeniedResponse) {}
                override fun onPermissionRationaleShouldBeShown(
                    permission: PermissionRequest,
                    token: PermissionToken
                ) {
                    token.continuePermissionRequest()
                }
            })
            .check()
    }

    fun savenama(id : String) {
        repository?.savenama(
            id,
            object : GeneralResponse.GeneralResponseCallback {
                override fun onSuccess(generalResponse: GeneralResponse) {
                    if (generalResponse.status == true) {
                        Toast.makeText(this@PindaiKeluarActivity, ""+generalResponse.message.toString(), Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(
                            this@PindaiKeluarActivity,
                            generalResponse.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(message: String) {
                    Toast.makeText(this@PindaiKeluarActivity, message, Toast.LENGTH_SHORT)
                        .show()
                }

            })
    }

    private fun showAlertDialog(id: String, data:String) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.pulangalertlayout, null)
        mDialogView.tvnama.setText(data)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("Ambil Souvenir")
        val  mAlertDialog = mBuilder.show()

        mDialogView.submit.setOnClickListener {
            mAlertDialog.dismiss()
        }
    }

    private fun sendnama(id: String) {

        val queue = Volley.newRequestQueue(this)
        var alamat=url+id
        Log.d("response ", alamat)

        stringRequest = StringRequest(
            Request.Method.GET,
            alamat,
            Response.Listener { response ->
                try {
                    val jsonObject = JSONObject(response)
                    val jsonArray = jsonObject.getString("message")
                    getdata(id)
                    //
//                    }
                } catch (e: JSONException) {
                    Toast.makeText(
                        this,
                        "$e",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            },
            Response.ErrorListener { error ->
                Toast.makeText(
                    this,
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            })
        queue.add(stringRequest);

    }


    private fun getdata(id: String): String  {
        var name="kosong"
        val queue = Volley.newRequestQueue(this)
        var alamat=urlget+id;

        stringRequest = StringRequest(
            Request.Method.GET,
            alamat,
            Response.Listener { response ->
                var jsonObject = JSONArray(response)
                    var i:Int = 0
                    var size:Int = jsonObject.length()
                    for (i in 0.. size-1) {
                        var objectdetail:JSONObject=jsonObject.getJSONObject(i)
                        name=objectdetail.getString("nama")
                        Toast.makeText(this@PindaiKeluarActivity, ""+name, Toast.LENGTH_LONG).show()

//                        showAlertDialog(id, name)
                        codeScanner.startPreview()

                    }
            },
            Response.ErrorListener { error ->
                Toast.makeText(
                    this,
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            })
        queue.add(stringRequest);

        return name
    }
}

