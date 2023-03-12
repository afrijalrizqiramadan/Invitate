package com.asyabab.invitate.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.core.content.ContextCompat
import com.asyabab.invitate.R
import com.asyabab.invitate.data.local.SharedPrefHelper

class SettingsActivity : AppCompatActivity() {

    lateinit var toolbar:androidx.appcompat.widget.Toolbar

    lateinit var eturl:EditText
    lateinit var bturl:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)
        val sharedPreference:SharedPrefHelper= SharedPrefHelper(this)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar?.title = ""
//        toolbar?.subtitle = "Sub"
//        toolbar?.navigationIcon = ContextCompat.getDrawable(this,R.drawable.dp_ic_setting)
//        toolbar?.setNavigationOnClickListener { Toast.makeText(applicationContext,"Navigation icon was clicked",Toast.LENGTH_SHORT).show() }

        eturl = findViewById(R.id.eturl)
        bturl = findViewById(R.id.bturl)

        bturl?.setOnClickListener {
            val url=eturl.editableText.toString()
            sharedPreference.putString("url",url)
            if (sharedPreference.getString("url")!=null) {
                Toast.makeText(this@SettingsActivity,"Sukses "+sharedPreference.getString("url")!!,Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object{
        var tvResult: TextView? = null
    }
}