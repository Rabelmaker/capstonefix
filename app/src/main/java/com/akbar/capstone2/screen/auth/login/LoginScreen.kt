package com.akbar.capstone2.screen.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.akbar.capstone2.R
import com.akbar.capstone2.screen.auth.register.showMessage
import com.akbar.capstone2.ui.component.PasswordTextFieldCustom
import com.akbar.capstone2.ui.component.TextFieldCustom
import com.akbar.capstone2.ui.component.WhiteButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun LoginScreenContent(
    modifier: Modifier = Modifier,
    navigateToRegister: () -> Unit,
    navController: NavController,
) {
    val context = LocalContext.current
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }



    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(R.drawable.backgroundlogin),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Surface(
            color = Color(0xff007335).copy(alpha = 0.8f),
            modifier = modifier.fillMaxSize()
        ) {}
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.verticalScroll(rememberScrollState())
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(R.string.welcome),
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                color = Color.White,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = modifier.fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(R.drawable.logodark),
                    contentDescription = null,
                    modifier = modifier
                        .size(85.dp)
                        .padding(end = 16.dp)
                )
                Column {
                    Text(
                        text = stringResource(R.string.AgroClima),
                        color = Color.White,
                        fontSize = 36.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = stringResource(R.string.quote),
                        color = Color.White,
                        fontSize = 12.sp,
                    )
                }
            }
            TextFieldCustom(
                title = "Email",
                value = email,
                onValueChange = { email = it },
                modifier = modifier.padding(vertical = 8.dp),
                placeholder = "",
                keyboardInt = false
            )
            PasswordTextFieldCustom(
                title = "Password",
                value = password,
                onValueChange = { password = it },
                placeholder = ""
            )
            WhiteButton(
                text = stringResource(R.string.Login),
                modifier = modifier.padding(horizontal = 16.dp, vertical = 50.dp),
                onClick = {
                    if (email.isEmpty()) {
                        showMessage(context, "Email must be filled")
                        return@WhiteButton
                    }
                    if (password.isEmpty()) {
                        showMessage(context, "Password must be filled")
                        return@WhiteButton
                    }
                    CoroutineScope(Dispatchers.Main).launch {
                        loginUser(
                            email = email,
                            password = password,
                            context = context,
                            navController = navController
                        )
                    }
                }
            )
            Row {
                Text(
                    text = stringResource(R.string.dontHaveAccount),
                    color = Color.White,
                )
                Text(
                    text = stringResource(R.string.registerNow),
                    color = Color.Yellow,
                    modifier = modifier
                        .padding(start = 4.dp)
                        .clickable { navigateToRegister() }
                )
            }
        }
    }
}
