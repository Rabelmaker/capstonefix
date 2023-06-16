package com.akbar.capstone2.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.akbar.capstone2.R
import com.akbar.capstone2.model.WeatherModel

@Composable
fun WeatherCard(
    card: WeatherModel,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier
            .fillMaxWidth(),
        shape = RoundedCornerShape(10.dp),

        ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
        ) {
            Image(
                painter = painterResource(card.icon),
                contentDescription = null,
                modifier = Modifier
                    .height(80.dp)
                    .padding(vertical = 16.dp)

            )
            Column {
                Text(
                    text = "Today",
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 14.sp
                )
                Text(
                    text = card.temp,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 24.sp
                )
            }
            Column(
                horizontalAlignment = Alignment.End
            ) {
                Row {
                    Text(
                        text = card.city,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 14.sp
                    )
                    Text(
                        text = card.clock,
                        color = MaterialTheme.colorScheme.primary,
                        fontSize = 14.sp
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = modifier.padding(end = 2.dp)

                    ) {
                        Image(
                            painter = painterResource(R.drawable.humadity),
                            contentDescription = null,
                            modifier = Modifier
                                .height(35.dp)
                                .padding(horizontal = 6.dp, vertical = 4.dp)
                        )
                        Text(
                            text = card.humadity,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    }

                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Image(
                            painter = painterResource(R.drawable.wind),
                            contentDescription = null,
                            modifier = Modifier
                                .height(35.dp)
                                .padding(horizontal = 6.dp, vertical = 4.dp)
                        )
                        Text(
                            text = card.windspeed,
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp
                        )
                    }
                }
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun WeatherPreview() {
    MaterialTheme {
        WeatherCard(
            card = WeatherModel(R.drawable.day, "25°C", "Pekanbaru, ", "12:00 PM", "50 %", "10 m/s"),
            modifier = Modifier.padding(8.dp)
        )
    }
}