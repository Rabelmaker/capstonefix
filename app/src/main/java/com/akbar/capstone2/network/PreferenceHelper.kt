package com.akbar.capstone2.network

import android.content.Context
import androidx.preference.PreferenceManager

object PreferenceHelper {
    private const val KEY_TOKEN = "token"
    private const val KEY_STATUS = "status"

    fun saveToken(context: Context, token: String) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().putString(KEY_TOKEN, token).apply()
    }

    fun getToken(context: Context): String? {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getString(KEY_TOKEN, null)
    }

    fun clearToken(context: Context) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_TOKEN).apply()
    }

    fun setStatusLogin(context: Context, status: Boolean){
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().putBoolean(KEY_STATUS, status).apply()
    }

    fun getStatusLogin(context: Context): Boolean {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        return prefs.getBoolean(KEY_STATUS, false)
    }

    fun clearStatusLogin(context: Context) {
        val prefs = PreferenceManager.getDefaultSharedPreferences(context)
        prefs.edit().remove(KEY_STATUS).apply()
    }
}
