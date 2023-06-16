//package com.akbar.capstone2.screen.reccomend
//
//import android.content.Context
//import android.util.Log
//import android.widget.Toast
//import androidx.navigation.NavController
//import com.akbar.capstone2.model.auth.RegisterModel
//import com.akbar.capstone2.model.recomend.RecomendModel
//import com.akbar.capstone2.network.ApiHelper
//import com.akbar.capstone2.network.ApiHelper2
//
//suspend fun recomend(
//    context: Context,
//    N: Double,
//    P: Double,
//    K:Double,
//    temperature: Double,
//    humidity: Double,
//    ph: Double,
//    rainfall: Double,
//    navController: NavController
//) {
//    val recomendRequest = RecomendModel(N, P, K, temperature, humidity,ph,rainfall)
//
//    try {
//        val response = ApiHelper2.getApiService().predict(recomendRequest)
//        if (response.status) {
//            showMessage(context, "Registration successful")
//            Log.d("Login", "Response message: ${response.msg}")
//            navController.navigate("login") {
//                popUpTo("register") {
//                    inclusive = true
//                }
//            }
//        } else {
//            showMessage(context, "Registration failed: ${response.msg}")
//            Log.d("Login", "Response message: ${response.msg}")
//        }
//    } catch (e: Exception) {
//        showMessage(context, "Registration failed: ${e.message}")
//    }
//
//}
//
//fun showMessage(context: Context, message: String) {
//    Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
//
//}