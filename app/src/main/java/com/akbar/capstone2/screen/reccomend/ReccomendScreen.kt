package com.akbar.capstone2.screen.reccomend

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.akbar.capstone2.R
import com.akbar.capstone2.ui.component.TextFieldCustom
import com.akbar.capstone2.ui.theme.md_theme_light_primary

@Composable
fun ReccomendScreen(
    modifier: Modifier = Modifier
) {
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
                    containerColor = md_theme_light_primary )
            ) {
                Column (
                    modifier.padding(bottom = 16.dp)
                        ){
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
                    containerColor = md_theme_light_primary )
            ) {
                Column (
                    modifier.padding(bottom = 16.dp)
                        ){
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
        Button(onClick = {}) {
            Text(text = stringResource(R.string.start_analyze))
        }
    }
}