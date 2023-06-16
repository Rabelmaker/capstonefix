package com.akbar.capstone2.screen.reccomend

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.akbar.capstone2.R
import com.akbar.capstone2.ui.component.TextFieldCustom
import com.akbar.capstone2.ui.theme.md_theme_light_primary
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun ReccomendScreen(
    modifier: Modifier = Modifier,
    onClick:()->Unit,
    navController: NavController,
) {
    val context = LocalContext.current
    var phosphorous by rememberSaveable { mutableStateOf("") }
    var nitrogen by rememberSaveable { mutableStateOf("") }
    var potassium by rememberSaveable { mutableStateOf("") }
    var pH by rememberSaveable { mutableStateOf("") }
    var temp by rememberSaveable { mutableStateOf("") }
    var humadity by rememberSaveable { mutableStateOf("") }
    var rainfall by rememberSaveable { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(enabled = true, state = rememberScrollState())
            .padding(16.dp)
    ) {
        Row {
            Image(
                painter = painterResource(R.drawable.chemicals),
                contentDescription = null,
                modifier
                    .size(75.dp)
                    .padding(end = 16.dp)
            )
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = md_theme_light_primary
                )
            ) {
                Column(
                    modifier.padding(bottom = 16.dp)
                ) {
                    TextFieldCustom(
                        title = stringResource(R.string.phosphorous_in_soil),
                        value = phosphorous,
                        onValueChange = { phosphorous = it },
                        placeholder = "",
                        keyboardInt = true
                    )
                    TextFieldCustom(
                        title = stringResource(R.string.nitrogen),
                        value = nitrogen,
                        onValueChange = { nitrogen = it },
                        placeholder = "",
                        keyboardInt = true
                    )
                    TextFieldCustom(
                        title = stringResource(R.string.potassium_in_soil),
                        value = potassium,
                        onValueChange = { potassium = it },
                        placeholder = "",
                        keyboardInt = true
                    )
                    TextFieldCustom(
                        title = stringResource(R.string.ph_in_soil),
                        value = pH,
                        onValueChange = { pH = it },
                        placeholder = "",
                        keyboardInt = true
                    )
                }
            }

        }
        Spacer(modifier = Modifier.size(16.dp))
        Row {
            Image(
                painter = painterResource(R.drawable.clouds),
                contentDescription = null,
                modifier
                    .size(75.dp)
                    .padding(end = 16.dp)
            )
            Card(
                colors = CardDefaults.cardColors(
                    containerColor = md_theme_light_primary
                )
            ) {
                Column(
                    modifier.padding(bottom = 16.dp)
                ) {
                    TextFieldCustom(
                        title = stringResource(R.string.temperature_c),
                        value = temp,
                        onValueChange = { temp = it },
                        placeholder = "",
                        keyboardInt = true
                    )
                    TextFieldCustom(
                        title = stringResource(R.string.humidity),
                        value = humadity,
                        onValueChange = { humadity = it },
                        placeholder = "",
                        keyboardInt = true
                    )
                    TextFieldCustom(
                        title = stringResource(R.string.rainfall),
                        value = rainfall,
                        onValueChange = { rainfall = it },
                        placeholder = "",
                        keyboardInt = true
                    )
                }
            }
        }
        Spacer(modifier = Modifier.size(16.dp))
        Button(
            onClick = {
                      onClick()
//                if (phosphorous.isEmpty()) {
//                    showMessage(
//                        context,
//                        "Phosphorous must be filled"
//                    )
//                    return@Button
//                }
//                if (nitrogen.isEmpty()) {
//                    showMessage(
//                        context,
//                        "Nitrogen must be filled"
//                    )
//                    return@Button
//                }
//
//                if (pH.isEmpty()) {
//                    showMessage(
//                        context,
//                        "pH must be filled"
//                    )
//                    return@Button
//                }
//                if (potassium.isEmpty()) {
//                    showMessage(
//                        context,
//                        "potassium must be filled"
//                    )
//                    return@Button
//                }
//                if (rainfall.isEmpty()) {
//                    showMessage(
//                        context,
//                        "Rainfall must be filled"
//                    )
//                    return@Button
//                }
//                if (temp.isEmpty()) {
//                    showMessage(
//                        context,
//                        "Temperature must be filled"
//                    )
//                    return@Button
//                }
//                if (humadity.isEmpty()) {
//                    showMessage(
//                        context,
//                        "Humidity must be filled"
//                    )
//                    return@Button
//                }
//                CoroutineScope(Dispatchers.Main).launch {
//                    recomend(
//                        N = nitrogen.toDouble(),
//                        P = phosphorous.toDouble(),
//                        K = potassium.toDouble(),
//                        temperature = temp.toDouble(),
//                        humidity = humadity.toDouble(),
//                        ph = pH.toDouble(),
//                        rainfall = rainfall.toDouble(),
//                        context = context,
//                        navController = navController
//                    )
//                }
            },
            modifier
                .fillMaxWidth()
                .size(50.dp)
        ) {
            Text(
                text = stringResource(R.string.start_analyze),
                fontWeight = FontWeight.Bold
            )
        }
    }
}