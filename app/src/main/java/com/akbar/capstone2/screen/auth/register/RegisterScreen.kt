package com.akbar.capstone2.screen.auth.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
import com.akbar.capstone2.ui.component.PasswordTextFieldCustom
import com.akbar.capstone2.ui.component.TextFieldCustom
import com.akbar.capstone2.ui.component.WhiteButton
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


@Composable
fun RegisterScreen(
    modifier: Modifier = Modifier,
    navigateToLogin: () -> Unit,
    navController: NavController,
) {
    val context = LocalContext.current
    var name by rememberSaveable { mutableStateOf("") }
    var noHp by rememberSaveable { mutableStateOf("") }
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmPassword by rememberSaveable { mutableStateOf("") }


    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(R.drawable.backback),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Surface(
            color = Color(0xff007335).copy(alpha = 0.8f), modifier = modifier.fillMaxSize()
        ) {}
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier
                .padding(vertical = 16.dp)
                .verticalScroll(enabled = true, state = rememberScrollState())
        ) {
            Text(
                textAlign = TextAlign.Center,
                text = stringResource(R.string.signUp),
                fontWeight = FontWeight.Bold,
                fontSize = 26.sp,
                color = Color.White,
                modifier = modifier
                    .padding(16.dp)
            )
            TextFieldCustom(
                title = "Name",
                value = name,
                onValueChange = { name = it },
                placeholder = "Your Name",
                keyboardInt = false
            )
            TextFieldCustom(
                title = "Email",
                value = email,
                onValueChange = { email = it },
                placeholder = " your email",
                keyboardInt = false

            )
            PasswordTextFieldCustom(
                title = "Password",
                value = password,
                onValueChange = { password = it },
                placeholder = "Password must be more 8 Character"
            )

            PasswordTextFieldCustom(
                title = "Confirm Password",
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeholder = "Repeat Password"
            )
            TextFieldCustom(
                title = "Phone number",
                value = noHp,
                onValueChange = { noHp = it },
                placeholder = " your Mobile Phone Number",
                keyboardInt = false
            )
            WhiteButton(
                text = stringResource(R.string.Register),
                modifier = modifier.padding(horizontal = 16.dp, vertical = 50.dp),
                onClick = {
                    if (name.isEmpty()) {
                        showMessage(context, "name must be filled")
                        return@WhiteButton
                    }
                    if (email.isEmpty()) {
                        showMessage(context, "Email must be filled")
                        return@WhiteButton
                    }

                    if (password.isEmpty()) {
                        showMessage(context, "Password must be filled")
                        return@WhiteButton
                    }
                    if (confirmPassword.isEmpty()) {
                        showMessage(context, "Confirm password must be filled")
                        return@WhiteButton
                    }
                    if (noHp.isEmpty()) {
                        showMessage(context, "Mobile phone number must be filled")
                        return@WhiteButton
                    }
                    CoroutineScope(Dispatchers.Main).launch {
                        registerUser(
                            name = name,
                            email = email,
                            no_hp = noHp,
                            password = password,
                            confirmPassword = confirmPassword,
                            context = context,
                            navController = navController
                        )
                    }
                },
                enabled = password.length >= 8
            )
            Row {
                Text(
                    text = stringResource(R.string.haveAccount),
                    color = Color.White,
                )
                Text(
                    text = stringResource(R.string.loginNow),
                    color = Color.Yellow,
                    modifier = modifier
                        .padding(start = 4.dp)
                        .clickable { navigateToLogin() }
                )
            }

        }
    }
}




