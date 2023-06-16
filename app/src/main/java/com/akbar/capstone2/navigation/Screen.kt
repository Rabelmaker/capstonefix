package com.akbar.capstone2.navigation

sealed class Screen(val route: String) {
    object Login : Screen("login")
    object Register : Screen("register")
    object Home : Screen("home")
    object Recommend : Screen("recommend")
    object PestAnalysis : Screen("pest_analysis")
    object Market : Screen("market")
    object Splash : Screen("splash")
    object Cart : Screen("cart")
    object Profile : Screen("profile")
    object Result : Screen("result")
    object DetailProduct : Screen("home/{productId}") {
        fun createRoute(productId: Long) = "home/$productId"
    }
}