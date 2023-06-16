package com.akbar.capstone2.screen.auth.login

import android.content.Context
import android.widget.Toast
import androidx.navigation.NavController
import com.akbar.capstone2.model.auth.LoginModel
import com.akbar.capstone2.network.ApiHelper
import com.akbar.capstone2.network.PreferenceHelper

suspend fun loginUser(
    context: Context,
    email: String,
    password: String,
    navController : NavController
) {

    val loginRequest = LoginModel(email, password)
    try {
        val response = ApiHelper.getApiService().login(loginRequest)
        if (response.status) {
            PreferenceHelper.saveToken(context, response.accessToken ?: "")
            PreferenceHelper.setStatusLogin(context, true)

            showMessage(context,"Login successful")
            navController.navigate("home") {
                popUpTo("login") {
                    inclusive = true
                }
            }
        } else {
            showMessage(context,"Login failed 1: ${response.msg}")
        }
    } catch (e: Exception) {
        showMessage(context,"Login failed 2: ${e.message}")
    }
}

private fun showMessage(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}