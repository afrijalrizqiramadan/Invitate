package com.asyabab.invitate.activity

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
import com.asyabab.invitate.R
import com.asyabab.invitate.base.DPBaseActivity
import com.asyabab.invitate.data.local.SharedPrefHelper
import com.asyabab.invitate.data.models.general.GeneralResponse
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

class PindaiActivity : DPBaseActivity() {
    private lateinit var codeScanner: CodeScanner
    var idundangan=""

    //    var url = "http://10.10.10.100/fastech/android/kirimnama.php?id_undangan="
    var url = ""
    var urlket = ""
    var urlget = ""
    var host = "http://"
    private var requestQueue: RequestQueue? = null
    private var stringRequest: StringRequest? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindai)
        val sharedPreference: SharedPrefHelper = SharedPrefHelper(this)

        if (sharedPreference.getString("url")!=null) {
            host+=sharedPreference.getString("url")!!
            Toast.makeText(this@PindaiActivity,"Sukses Host : "+host,Toast.LENGTH_SHORT).show()
        }
        val scannerView = findViewById<CodeScannerView>(R.id.scanner_view)

        codeScanner = CodeScanner(this, scannerView)
        url = host+"/android/kirimnamabaru.php?nama="
        urlket = host+"/android/kirimjumlah.php?id_undangan="
        urlget = host+"/android/getdata.php?id="
        codeScanner.camera = CodeScanner.CAMERA_FRONT // or CAMERA_FRONT or specific camera id
        codeScanner.formats = CodeScanner.TWO_DIMENSIONAL_FORMATS// list of type BarcodeFormat,
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
                        Toast.makeText(this@PindaiActivity, ""+generalResponse.message.toString(), Toast.LENGTH_LONG).show()
                    } else {
                        Toast.makeText(
                            this@PindaiActivity,
                            generalResponse.message.toString(),
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }

                override fun onFailure(message: String) {
                    Toast.makeText(this@PindaiActivity, message, Toast.LENGTH_SHORT)
                        .show()
                }

            })
    }

    private fun showAlertDialog(id: String, data:String) {
        val mDialogView = LayoutInflater.from(this).inflate(R.layout.alertlayout, null)
        mDialogView.tvnama.setText(data)
        val mBuilder = AlertDialog.Builder(this)
            .setView(mDialogView)
            .setTitle("Input Data")
        val  mAlertDialog = mBuilder.show()

        mDialogView.submit.setOnClickListener {
            mAlertDialog.dismiss()
            val jumlah = mDialogView.dialogjumlah.text.toString()
            val keterangan = mDialogView.dialogketerangan.text.toString()

            senddata(id,jumlah, keterangan)
        }
    }
    fun replaceSpaces(input: String): String {
        return input.replace(" ", "%20")
    }
    private fun sendnama(id: String) {

        val queue = Volley.newRequestQueue(this)
        val replacedString = replaceSpaces(id)
        var alamat=url+replacedString

        Log.d("response ", alamat)

        stringRequest = StringRequest(
            Request.Method.GET,
            alamat,
            { response ->
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
            { error ->
                Toast.makeText(
                    this,"Gagal"+
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            })
        queue.add(stringRequest);

    }
    private fun senddata(id: String, jumlah:String, keterangan:String) {

        val queue = Volley.newRequestQueue(this)
        var alamat=urlket+id;
        Log.d("response ", alamat)

        stringRequest = StringRequest(
            Request.Method.GET,
            alamat,
            Response.Listener { response ->
                try {
                    val jsonObject = JSONObject(response)
                    val jsonArray = jsonObject.getString("message")
                    Toast.makeText(
                        this,
                        ""+jsonArray.toString(),
                        Toast.LENGTH_SHORT
                    ).show()
//                    for (a in 0 until jsonArray.length()) {
//                        val json = jsonArray.getJSONObject(a)
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
            { response ->
//                var jsonObject = JSONObject(response)
//                    var i:Int = 0
//                    var size:Int = jsonObject.length()
//                    for (i in 0.. size-1) {
//                        var objectdetail:JSONObject=jsonObject.getJSONObject(i)
//                        name=objectdetail.getString("nama")
                        Toast.makeText(this@PindaiActivity, "Selamat Datang", Toast.LENGTH_LONG).show()
//
////                        showAlertDialog(id, name)
                        codeScanner.startPreview()
//                    }
            },
            { error ->
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

