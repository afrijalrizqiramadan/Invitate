package com.asyabab.invitate

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
import com.asyabab.invitate.data.Repository
import io.github.inflationx.calligraphy3.CalligraphyConfig
import io.github.inflationx.calligraphy3.CalligraphyInterceptor
import io.github.inflationx.viewpump.ViewPump

class DPApp : Application() {

    internal var repository: Repository? = null
    override fun onCreate() {
        super.onCreate()
        appInstance = this

        repository = Repository(applicationContext)

        // Set Custom Font
        ViewPump.init(
            ViewPump.builder().addInterceptor(
                CalligraphyInterceptor(
                    CalligraphyConfig.Builder()
                        .setDefaultFontPath(getString(R.string.dp_font_regular))
                        .setFontAttrId(R.attr.fontPath).build()
                )
            ).build()
        )
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    companion object {
        private lateinit var appInstance: DPApp

        fun getAppInstance(): DPApp {
            return appInstance
        }
    }
}
