package com.asyabab.invitate.data.local

import android.content.Context
import android.content.SharedPreferences

class SharedPrefHelper(context: Context) {

    private val M_PREF = "mvp"
    private val IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch"

    companion object {
        var ACCES_TOKEN = "token"
        var ACCES_UID_DOCTOR = "uid"
    }

    var editor: SharedPreferences.Editor
    private val mPreferences: SharedPreferences

    init {
        mPreferences = context.getSharedPreferences(M_PREF, Context.MODE_PRIVATE)
        editor = mPreferences.edit()

    }

    fun getString(key: String): String? {
        return mPreferences.getString(key, null)
    }

    fun getString(variable: String, value: String): String? {
        return mPreferences.getString(variable, value)
    }

    fun getInt(key: String): Int {
        return mPreferences.getInt(key, 0)
    }

    fun putString(key: String, value: String) {
        mPreferences.edit().putString(key, value).apply()
    }

    fun putInt(key: String, value: Int) {
        mPreferences.edit().putInt(key, value).apply()
    }

    fun clear() {
        mPreferences.edit().clear().apply()
    }

    fun setFirstTimeLaunch(isFirstTime: Boolean) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime)
        editor.commit()
    }

    fun isFirstTimeLaunch(): Boolean {
        return mPreferences.getBoolean(IS_FIRST_TIME_LAUNCH, true)
    }

}
