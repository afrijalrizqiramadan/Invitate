package com.asyabab.invitate.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.asyabab.invitate.R
import com.asyabab.invitate.data.local.SharedPrefHelper
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    lateinit var buttonScanmasuk:LinearLayout
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    lateinit var buttonScankeluar:LinearLayout
    lateinit var toolbar:androidx.appcompat.widget.Toolbar
    lateinit var btsetting:ImageView
    var idundangan=""

    //    var url = "http://10.10.10.100/fastech/android/kirimkeluar.php?id_undangan="
    var url = ""

    var host = "http://"
    private var requestQueue: RequestQueue? = null
    private var stringRequest: StringRequest? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreference: SharedPrefHelper = SharedPrefHelper(this)
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)
        swipeRefreshLayout.setOnRefreshListener {
            // Panggil fungsi refresh halaman di sini
            refreshPage()
        }
        if (sharedPreference.getString("url")!=null) {
            host+=sharedPreference.getString("url")!!
            Toast.makeText(this@MainActivity,"Sukses Host : "+host,Toast.LENGTH_SHORT).show()
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        getstatistik()
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar?.title = ""
//        toolbar?.subtitle = "Sub"
//        toolbar?.navigationIcon = ContextCompat.getDrawable(this,R.drawable.dp_ic_setting)
//        toolbar?.setNavigationOnClickListener { Toast.makeText(applicationContext,"Navigation icon was clicked",Toast.LENGTH_SHORT).show() }
        btsetting = findViewById(R.id.btsettings)
        buttonScanmasuk = findViewById(R.id.tv_scanmasuk)
        buttonScankeluar = findViewById(R.id.tv_scankeluar)

        url = host+"/server/android/kirimkeluar.php?id_undangan="


        buttonScanmasuk.setOnClickListener {
            val intent = Intent(this, PindaiActivity::class.java)
            startActivity(intent)
        }
        btsetting.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
        buttonScankeluar.setOnClickListener {
            val intent = Intent(this, PindaiKeluarActivity::class.java)
            startActivity(intent)
        }
    }
    private fun getstatistik()  {
        var jundangan=""
        var jpresensi=""
        var jtpresensi=""
        val queue = Volley.newRequestQueue(this)
        var alamat="https://server.invitate.id/android/getstatistik.php";

        stringRequest = StringRequest(
            Request.Method.GET,
            alamat,
            { response ->
                var jsonObject = JSONObject(response)

                    jundangan=jsonObject.getString("jumlah_undangan")
                    jpresensi=jsonObject.getString("jumlah_presensi")
                    jtpresensi= (jundangan.toInt()-jpresensi.toInt()).toString()
                    tvJumlahHadir.text = jpresensi
                    tvJumlahTamu.text = jundangan
                    tvJumlahTidakHadir.text = jtpresensi
//                        showAlertDialog(id, name)


            },
            { error ->
                Toast.makeText(
                    this,
                    error.message,
                    Toast.LENGTH_SHORT
                ).show()
            })
        queue.add(stringRequest);

    }
    private fun refreshPage() {
        getstatistik()
                swipeRefreshLayout.isRefreshing = false
    }
    companion object{
        var tvResult: TextView? = null
    }
}