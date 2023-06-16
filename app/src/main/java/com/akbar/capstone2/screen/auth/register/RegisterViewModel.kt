package com.akbar.capstone2.screen.auth.register

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import com.akbar.capstone2.model.auth.RegisterModel
import com.akbar.capstone2.network.ApiHelper

suspend fun registerUser(
    context: Context,
    name: String,
    email: String,
    no_hp:String,
    password: String,
    confirmPassword: String,
    navController: NavController
) {
    val registerRequest = RegisterModel(name, email, no_hp, password, confirmPassword)

    try {
        val response = ApiHelper.getApiService().register(registerRequest)
        if (response.status) {
            showMessage(context, "Registration successful")
            Log.d("Login", "Response message: ${response.msg}")
            navController.navigate("login") {
                popUpTo("register") {
                    inclusive = true
                }
            }
        } else {
            showMessage(context, "Registration failed: ${response.msg}")
            Log.d("Login", "Response message: ${response.msg}")
        }
    } catch (e: Exception) {
        showMessage(context, "Registration failed: ${e.message}")
    }

}

fun showMessage(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

}