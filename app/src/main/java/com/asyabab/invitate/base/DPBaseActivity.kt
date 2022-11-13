package com.asyabab.invitate.base

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.asyabab.invitate.DPApp
import com.asyabab.invitate.R
import com.asyabab.invitate.data.Repository
import com.asyabab.invitate.utils.DialogHelper
import com.asyabab.invitate.utils.getAppColor
import com.asyabab.invitate.utils.lightStatusBar
import com.asyabab.invitate.utils.onClick
import io.github.inflationx.viewpump.ViewPumpContextWrapper
import kotlinx.android.synthetic.main.dp_layout_back.*


open class DPBaseActivity : AppCompatActivity() {

    private lateinit var progressBar: AlertDialog

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lightStatusBar(getAppColor(R.color.dp_app_background))
        progressBar = DialogHelper.loading(this)

        if (ivBack != null) {
            ivBack.onClick {
                finish()
            }
        }
    }

//    protected val mAuth: FirebaseAuth?
//        get() = FirebaseAuth.getInstance()

    protected val loading: AlertDialog?
        get() = progressBar


    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase))
    }

    protected val repository: Repository?
        get() = (application as DPApp).repository


/*
    fun setToolbar(mToolbar: Toolbar) {
        setSupportActionBar(mToolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        mToolbar.setNavigationIcon(R.drawable.theme9_ic_arrow_back)
        mToolbar.setNavigationOnClickListener { onBackPressed() }
        mToolbar.changeToolbarFont()
    }
*/


//    fun loadFragment(fragment: Fragment?) {
//        if (fragment != null) {
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.frame_container, fragment)
//                .commit()
//        }
//    }
//
//    fun loadFragment(fragment: Fragment?, uid: String) {
//        if (fragment != null) {
//            val bundle = Bundle()
//            bundle.putString("uid", uid)
//            fragment.arguments = bundle
//            supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.frame_container, fragment)
//                .commit()
//        }
//    }
//
//    fun logout() {
//        repository!!.saveToken("")
//        repository!!.setFirstTimeLaunch(true)
//        mAuth!!.signOut()
//        launchActivityWithNewTask<DPWalkThroughActivity>()
//    }
}
