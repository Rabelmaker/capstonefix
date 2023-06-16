package com.akbar.capstone2.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.akbar.capstone2.model.ProfileModel
import com.akbar.capstone2.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopBar(
    profile : ProfileModel,
    onNavigateToProfile: () -> Unit,
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        modifier = modifier.padding(horizontal = 16.dp),
        navigationIcon = {
            Icon(
                painter = painterResource(R.drawable.logolight),
                contentDescription = null,
                modifier = modifier
                    .height(40.dp)
                    .padding(end = 4.dp)

            )
        },
        title = {
            Text(stringResource(R.string.AgroClima))
        },
        actions = {
            IconButton(onClick = {
            }) {
                Icon(
                    painter = painterResource(R.drawable.bell),
                    contentDescription = stringResource(R.string.menu),
                    modifier = modifier.size(24.dp)
                )
            }
            IconButton(onClick = {
            }) {
                Icon(
                    painter = painterResource(R.drawable.setting),
                    contentDescription = stringResource(R.string.menu),
                    modifier = modifier.size(24.dp)
                )
            }
            IconButton(onClick = {
            }) {
                Image(
                    painter = painterResource(profile.imageSlide),
                    contentDescription = stringResource(R.string.menu),
                    modifier = modifier
                        .size(40.dp)
                        .clickable {onNavigateToProfile()}
                )
            }
        },
    )
}