package com.akbar.capstone2.screen.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.akbar.capstone2.R
import com.akbar.capstone2.network.PreferenceHelper
import com.akbar.capstone2.ui.theme.AppTheme

@Composable
fun ProfileScreen(
    image: Int,
    name: String,
    email: String,
    number: Long,
    back: () -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val context = LocalContext.current
    Column(
        modifier = modifier.fillMaxSize(),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Card(
                modifier
                    .padding(16.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .clickable { back() }
            ) {
                Icon(
                    tint = MaterialTheme.colorScheme.primary,
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier
                        .padding(16.dp)
                )
            }
            Text(
                text = "Profile",
                modifier = modifier.padding(horizontal = 24.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = name,
                modifier = modifier
                    .clip(RoundedCornerShape(100.dp))
                    .size(120.dp)
                    .padding(16.dp)
            )
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = name,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "$number",
                    color = MaterialTheme.colorScheme.outline,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = email,
                    color = MaterialTheme.colorScheme.outline,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        Divider(
            modifier = modifier.padding(16.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Person,
                contentDescription = name,
                tint = MaterialTheme.colorScheme.primary,
                modifier = modifier
                    .size(36.dp)
                    .padding(end = 16.dp)
            )
            Column {
                Text(
                    color = MaterialTheme.colorScheme.secondary,
                    text = "Username",
                    fontSize = 12.sp,
                    modifier = modifier.padding(2.dp)
                )
                Text(
                    text = name,
                    fontSize = 16.sp,
                    modifier = modifier.padding(2.dp)
                )
                Divider(
                    thickness = 2.dp
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = name,
                tint = MaterialTheme.colorScheme.primary,
                modifier = modifier
                    .size(36.dp)
                    .padding(end = 16.dp)
            )
            Column {
                Text(
                    color = MaterialTheme.colorScheme.secondary,
                    text = "Location",
                    fontSize = 12.sp,
                    modifier = modifier.padding(2.dp)
                )
                Text(
                    text = "Perumahan Graha Rajawali blok H.6",
                    fontSize = 16.sp,
                    modifier = modifier.padding(2.dp)
                )
                Divider(
                    thickness = 2.dp
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Email,
                contentDescription = name,
                tint = MaterialTheme.colorScheme.primary,
                modifier = modifier
                    .size(36.dp)
                    .padding(end = 16.dp)
            )
            Column {
                Text(
                    color = MaterialTheme.colorScheme.secondary,
                    text = "Email",
                    fontSize = 12.sp,
                    modifier = modifier.padding(2.dp)
                )
                Text(
                    text = email,
                    fontSize = 16.sp,
                    modifier = modifier.padding(2.dp)
                )
                Divider(
                    thickness = 2.dp
                )
            }
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = name,
                tint = MaterialTheme.colorScheme.primary,
                modifier = modifier
                    .size(36.dp)
                    .padding(end = 16.dp)
            )
            Column {
                Text(
                    color = MaterialTheme.colorScheme.secondary,
                    text = "Job",
                    fontSize = 12.sp,
                    modifier = modifier.padding(2.dp)
                )
                Text(
                    text = "Farmer",
                    fontSize = 16.sp,
                    modifier = modifier.padding(2.dp)
                )
                Divider(
                    thickness = 2.dp
                )
            }
        }
        Button(
            onClick = {
                PreferenceHelper.clearStatusLogin(context)
                navController.navigate("login")
            },
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 24.dp)
                .fillMaxWidth()
        ) {
            Text(text = "Logout")
        }
    }

}
