package com.asyabab.invitate.activity

import android.os.Bundle
import android.os.Handler
import com.asyabab.invitate.R
import com.asyabab.invitate.base.DPBaseActivity
import com.asyabab.invitate.utils.launchActivity
import com.google.android.play.core.appupdate.AppUpdateManager

//import com.google.firebase.auth.FirebaseUser

class DPSplashActivity : DPBaseActivity() {
    private lateinit var appUpdateManager: AppUpdateManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dp_activity_splash)

//        repository?.versionCodeCheck(object : GeneralResponse.GeneralResponseCallback {
//            override fun onSuccess(generalResponse: GeneralResponse) {
//                if (generalResponse.status == true) {
//                    val versionFromServer = generalResponse.message!!.toInt()
//                    val versionCode =
//                        BuildConfig.VERSION_CODE
//                    if (versionFromServer > versionCode) {
                        Handler().postDelayed({
//                            update()
                            launchActivity<MainActivity>()

                        }, 1000)
//                    } else {
//launchActivity<MainActivity>()
////                        goToSplashScreen()
//                    }
//                } else {
//                    launchActivity<MainActivity>()
//
////                    goToSplashScreen()
//                }
//            }
//
//            override fun onFailure(message: String) {
//                Toast.makeText(this@DPSplashActivity, "Ganngguan jaringan", Toast.LENGTH_LONG)
//                    .show()
//                launchActivity<MainActivity>()
//
////                goToSplashScreen()
//            }
//
//        })


//        appUpdateManager = AppUpdateManagerFactory.create(this)
//        val appUpdateInfoTask = appUpdateManager.appUpdateInfo
//        appUpdateInfoTask.addOnSuccessListener {
//            if (it.updateAvailability() == UpdateAvailability.UPDATE_AVAILABLE
//                && it.isUpdateTypeAllowed(AppUpdateType.IMMEDIATE)
//            ) {
//                appUpdateManager.startUpdateFlowForResult(
//                    it,
//                    AppUpdateType.IMMEDIATE,
//                    this,
//                    999
//                )
//            } else {
//                // TODO: do something in here if update not available
//            }
//        }

//        changeUI()


    }

//    private fun update() {
//
//        val dialog = Dialog(this)
//        dialog.apply {
//            requestWindowFeature(Window.FEATURE_NO_TITLE)
//            setContentView(R.layout.dp_dialog_version_code)
//            window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//            window?.setLayout(
//                RelativeLayout.LayoutParams.MATCH_PARENT,
//                RelativeLayout.LayoutParams.WRAP_CONTENT
//            )
//            tvOK.onClick {
//                val url = "https://play.google.com/store/apps/details?id=pasien.ruangpraktek"
//                val i = Intent(Intent.ACTION_VIEW)
//                i.data = Uri.parse(url)
//                startActivity(i)
//            }
//            show()
//        }
//    }

//    fun goToSplashScreen() {
//        val intent = intent
//        if (intent != null) {
//            val uri = intent.data
//            if (uri != null) {
//                if (TextUtils.isEmpty(uri.path) || uri.path == "/") {
//                    Handler().postDelayed({
//                        if (!TextUtils.isEmpty(repository?.getToken())) {
//                            val currentUser = mAuth?.currentUser
//                            updateUI(currentUser)
//                        } else {
//                            launchActivity<DPWalkThroughActivity>()
//                            finish()
//                        }
//                    }, 1000)
//                } else {
//                    val params: List<String> = uri.pathSegments
//                    val username = params[0]
//                    if (!TextUtils.isEmpty(repository?.getToken())) {
//                        launchActivity<DPDetailInformationActivity2> {
//                            putExtra("username", username)
//                        }
//                        finish()
//                    } else {
//                        launchActivity<DPWalkThroughActivity> {
//                            putExtra("username", username)
//                        }
//                        finish()
//                    }
//                }
//            } else {
//                Handler().postDelayed({
//                    if (!TextUtils.isEmpty(repository?.getToken())) {
//                        val currentUser = mAuth?.currentUser
//                        updateUI(currentUser)
//                    } else {
//                        launchActivity<DPWalkThroughActivity>()
//                        finish()
//                    }
//                }, 1000)
//            }
//        } else {
//            Handler().postDelayed({
//                if (!TextUtils.isEmpty(repository?.getToken())) {
//                    val currentUser = mAuth?.currentUser
//                    updateUI(currentUser)
//                } else {
//                    launchActivity<DPWalkThroughActivity>()
//                    finish()
//                }
//            }, 1000)
//        }
//
//    }

//    fun updateUI(user: FirebaseUser?) {
//        if (user != null) {
//            Log.e("hasil", user.displayName.toString())
//
//            login(user.email!!, user.uid)
//        } else {
//            launchActivity<DPWalkThroughActivity>()
//            finish()
//        }
//    }

//    fun login(email: String, uid: String) {
//        repository!!.login(email, uid, object : LoginResponse.LoginResponseCallback {
//            override fun onSuccess(loginResponse: LoginResponse) {
//                if (loginResponse.status == true) {
//                    val token = loginResponse.data!!.token
//                    repository!!.saveToken(token)
//                    Log.e("hasil", repository?.getToken().toString())
//                    if (loginResponse.data!!.lengkap.equals("YA")) {
//                        launchActivity<DPDashboardActivity>()
//                        finish()
//                    } else {
//                        launchActivity<DPSignUpStepsActivity> { }
//                        finish()
//                    }
//                } else {
//                    launchActivity<DPWalkThroughActivity>()
//                    finish()
//                }
//            }
//
//            override fun onFailure(message: String) {
//                Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
//                launchActivity<DPWalkThroughActivity>()
//                finish()
//            }
//
//        })
//    }

//    override fun onResume() {
//        appUpdateManager.appUpdateInfo
//            .addOnSuccessListener {
//                if (it.updateAvailability() == UpdateAvailability.DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS) {
//                    appUpdateManager.startUpdateFlowForResult(
//                        it,
//                        AppUpdateType.IMMEDIATE,
//                        this,
//                        999
//                    )
//                }
//            }
//        super.onResume()
//    }
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//        if (requestCode == 999 && resultCode == Activity.RESULT_OK) {
//            // TODO: do something in here if in-app updates success
//        } else {
//            // TODO: do something in here if in-app updates failure
//        }
//    }
}