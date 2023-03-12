package com.asyabab.invitate.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import com.asyabab.invitate.R
import com.asyabab.invitate.data.local.SharedPrefHelper

class MainActivity : AppCompatActivity() {
    lateinit var buttonScanmasuk:LinearLayout
    lateinit var buttonScankeluar:LinearLayout
    lateinit var toolbar:androidx.appcompat.widget.Toolbar
    lateinit var btsetting:ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreference:SharedPrefHelper= SharedPrefHelper(this)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar?.title = ""
//        toolbar?.subtitle = "Sub"
//        toolbar?.navigationIcon = ContextCompat.getDrawable(this,R.drawable.dp_ic_setting)
//        toolbar?.setNavigationOnClickListener { Toast.makeText(applicationContext,"Navigation icon was clicked",Toast.LENGTH_SHORT).show() }
        btsetting = findViewById(R.id.btsettings)
        buttonScanmasuk = findViewById(R.id.tv_scanmasuk)
        buttonScankeluar = findViewById(R.id.tv_scankeluar)


        buttonScanmasuk?.setOnClickListener {
            val intent = Intent(this, PindaiActivity::class.java)
            startActivity(intent)
        }
        btsetting?.setOnClickListener {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
        buttonScankeluar?.setOnClickListener {
            val intent = Intent(this, PindaiKeluarActivity::class.java)
            startActivity(intent)
        }
    }

    companion object{
        var tvResult: TextView? = null
    }
}