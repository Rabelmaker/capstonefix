package com.akbar.capstone2.ui.component
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.akbar.capstone2.ui.theme.AppTheme


@Composable
fun TextFieldCustom(
    title: String,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    placeholder: String,
    keyboardInt : Boolean
) {
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = modifier.padding(horizontal = 16.dp)
    ) {
        Text(
            text = title,
            color = Color.White,
            modifier = modifier.padding(8.dp)
        )
        OutlinedTextField(
            singleLine = true,
            keyboardOptions = if (keyboardInt == true ){
                KeyboardOptions(keyboardType = KeyboardType.Number)
            } else {
                KeyboardOptions(keyboardType = KeyboardType.Text)
            },
            value = value,
            placeholder = {
                Text(
                    text = placeholder,
                    color = Color.White.copy(alpha = 0.6f)
                )
            },
            onValueChange = onValueChange,
            colors = TextFieldDefaults.colors(
                focusedTextColor = Color.White,
                focusedContainerColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                disabledContainerColor = Color.Transparent,
                cursorColor = Color.White,
                focusedIndicatorColor = Color.White,
                unfocusedIndicatorColor = Color.White,
                disabledIndicatorColor = Color.Transparent,
                unfocusedTextColor = Color.White
            ),
            modifier = modifier
                .fillMaxWidth()
                .heightIn(min = 48.dp)
        )
    }
}


@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun LoginPreview() {
    AppTheme {
        TextFieldCustom(
            title = "email",
            value = "blabla",
            onValueChange = {},
            placeholder = "gunakan 8 karakter",
            keyboardInt = true
        )
    }
}
