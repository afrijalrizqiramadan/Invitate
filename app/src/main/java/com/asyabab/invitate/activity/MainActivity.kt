package com.asyabab.invitate.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.asyabab.invitate.R
import com.asyabab.invitate.data.local.SharedPrefHelper

class MainActivity : AppCompatActivity() {
    lateinit var buttonScanmasuk:LinearLayout
    lateinit var buttonScankeluar:LinearLayout
    lateinit var eturl:EditText
    lateinit var bturl:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sharedPreference:SharedPrefHelper= SharedPrefHelper(this)

        buttonScanmasuk = findViewById(R.id.tv_scanmasuk)
        buttonScankeluar = findViewById(R.id.tv_scankeluar)
        eturl = findViewById(R.id.eturl)
        bturl = findViewById(R.id.bturl)

        buttonScanmasuk?.setOnClickListener {
            val intent = Intent(this, PindaiActivity::class.java)
            startActivity(intent)
        }
        buttonScankeluar?.setOnClickListener {
            val intent = Intent(this, PindaiKeluarActivity::class.java)
            startActivity(intent)
        }

        bturl?.setOnClickListener {
            val url=eturl.editableText.toString()
            sharedPreference.putString("url",url)
            if (sharedPreference.getString("url")!=null) {
                Toast.makeText(this@MainActivity,"Sukses "+sharedPreference.getString("url")!!,Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object{
        var tvResult: TextView? = null
    }
}