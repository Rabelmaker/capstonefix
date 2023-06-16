package com.akbar.capstone2

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.akbar.capstone2.screen.reccomend.ReccomendScreen
import com.akbar.capstone2.model.ProfileModel
import com.akbar.capstone2.navigation.Screen
import com.akbar.capstone2.screen.auth.login.LoginScreenContent
import com.akbar.capstone2.screen.auth.register.RegisterScreen
import com.akbar.capstone2.screen.cart.CartScreen
import com.akbar.capstone2.screen.detail.DetailLogic
import com.akbar.capstone2.screen.home.HomeScreen
import com.akbar.capstone2.screen.market.MarketScreenLogic
import com.akbar.capstone2.screen.pest_analysis.PestAnalysisScreen
import com.akbar.capstone2.screen.profile.ProfileScreen
import com.akbar.capstone2.screen.splashscren.SplashScreen
import com.akbar.capstone2.ui.component.BottomBar
import com.akbar.capstone2.ui.component.MyTopBar
import kotlinx.coroutines.delay


@Composable
fun CapstoneApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    val showSplashScreen = remember { mutableStateOf(true) }
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val context = LocalContext.current

    Scaffold(
        topBar = {
            if (
                currentRoute != Screen.Market.route &&
                currentRoute != Screen.Login.route &&
                currentRoute != Screen.Register.route &&
                currentRoute != Screen.DetailProduct.route &&
                currentRoute != Screen.Cart.route &&
                currentRoute != Screen.Profile.route &&
                currentRoute != Screen.Splash.route
            ) {
                MyTopBar(
                    onNavigateToProfile = { navController.navigate("profile") },
                    profile = ProfileModel(R.drawable.man),
                )
            }
        },
        bottomBar = {
            if (currentRoute != Screen.DetailProduct.route &&
                currentRoute != Screen.Cart.route &&
                currentRoute != Screen.Login.route &&
                currentRoute != Screen.Register.route &&
                currentRoute != Screen.Profile.route &&
                currentRoute != Screen.Splash.route
            ) {
                BottomBar(navController)
            }
        },
        modifier = modifier
    ) { paddingValues ->
        NavHost(
            navController = navController,
            startDestination = if (showSplashScreen.value) {
                Screen.Splash.route
            } else {
                Screen.Login.route
            },
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screen.Register.route) {
                RegisterScreen(
                    navigateToLogin = { navController.navigate("login") },
                    navController = navController
                )
            }
            composable(Screen.Login.route) {
                LoginScreenContent(
                    navigateToRegister = { navController.navigate("register") },
                    navController = navController
                )
            }
            composable(Screen.Home.route) {
                HomeScreen(
                    navController = navController,

                )
            }
            composable(Screen.Cart.route) {
                CartScreen(
                    navigateBack = { navController.navigateUp() },
                    onOrderButtonClicked = { message ->
                        shareOrder(context, message)
                    }
                )
            }
            composable(Screen.Recommend.route) {
                ReccomendScreen()
            }
            composable(Screen.Splash.route) {
                SplashScreen()
                LaunchedEffect(Unit) {
                    // Menggunakan delay untuk menentukan durasi tampilan splash screen (misalnya 2 detik)
                    delay(2000)
                    showSplashScreen.value = false
                }
            }

            composable(Screen.PestAnalysis.route) {
                PestAnalysisScreen()
            }
            composable(Screen.Profile.route) {
                ProfileScreen(
                    name = "Akbar Maulana",
                    back = { navController.navigateUp() },
                    image = R.drawable.man,
                    email = "akbar.maulana26061999@gmail.com",
                    number = 6281266110409,
                    navController = navController
                )
            }
            composable(Screen.Cart.route) {
                CartScreen(
                    navigateBack = { navController.navigateUp() },
                    onOrderButtonClicked = { message ->
                        shareOrder(context, message)
                    }
                )
            }
            composable(Screen.Market.route) {
                MarketScreenLogic(
                    navController = navController,
                    navigateToDetail = { productId ->
                        navController.navigate(Screen.DetailProduct.createRoute(productId))
                    }
                )
            }
            composable(
                route = Screen.DetailProduct.route,
                arguments = listOf(navArgument("productId") { type = NavType.LongType }),
            ) {
                val id = it.arguments?.getLong("productId") ?: -1L
                DetailLogic(
                    productId = id,
                    navigateBack = {
                        navController.navigateUp()
                    },
                    navigateToCart = {
                        navController.popBackStack()
                        navController.navigate(Screen.Cart.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                saveState = true
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }

        }
    }
}

private fun shareOrder(context: Context, summary: String) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_SUBJECT, context.getString(R.string.product_purchase))
        putExtra(Intent.EXTRA_TEXT, summary)
    }

    context.startActivity(
        Intent.createChooser(
            intent,
            context.getString(R.string.product_purchase)
        )
    )
}