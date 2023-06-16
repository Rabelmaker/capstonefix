package com.akbar.capstone2.screen.reccomend

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.navigation.NavController
import com.akbar.capstone2.model.recomend.RecomendModel
import com.akbar.capstone2.network.ApiHelper2

suspend fun recomend(
    context: Context,
    N: Double,
    P: Double,
    K: Double,
    temperature: Double,
    humidity: Double,
    ph: Double,
    rainfall: Double,
    navController: NavController
) {
    val recomendRequest = RecomendModel(N, P, K, temperature, humidity,ph,rainfall)

    try {
        val response = ApiHelper2.getApiService().predict(recomendRequest)
        if (response.status) {
            navController.navigate("result") {
                popUpTo("recommend") {
                    inclusive = true
                }
            }
            showMessage(context, "Predict successful")
            Log.d("predict", "Response message: ${response.message}")

        } else {
            showMessage(context, "predict failed1: ${response.message}")
            Log.d("predict", "Response message: ${response.message}")
        }
    } catch (e: Exception) {
        showMessage(context, "predict failed2: ${e.message}")
    }

}

fun showMessage(context: Context, message: String) {
    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

}