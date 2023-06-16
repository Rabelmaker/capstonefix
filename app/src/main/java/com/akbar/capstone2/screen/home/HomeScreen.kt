package com.akbar.capstone2.screen.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.akbar.capstone2.R
import com.akbar.capstone2.common.UiState
import com.akbar.capstone2.model.FakeProductDataSource
import com.akbar.capstone2.model.WeatherModel
import com.akbar.capstone2.model.slide.SlideResponse
import com.akbar.capstone2.network.PreferenceHelper
import com.akbar.capstone2.ui.component.ProductItem
import com.akbar.capstone2.ui.component.SlideItem
import com.akbar.capstone2.ui.component.Title
import com.akbar.capstone2.ui.component.TitleWithSeeAll
import com.akbar.capstone2.ui.component.WeatherCard
import com.akbar.capstone2.util.SlideCacheUtil

@Composable
fun HomeScreen(
    navController: NavController,
    homeViewModel: HomeViewModel = viewModel()
) {
    val uiState by homeViewModel.uiState.collectAsState()

    // Mengecek status login dan melakukan navigasi jika tidak login
    val context = LocalContext.current
    if (!PreferenceHelper.getStatusLogin(context)) {
        navController.navigate("home")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(enabled = true, state = rememberScrollState())
    ) {
        Banner()
        Title(title = "Around agriculture")
        when (uiState) {
            is UiState.Success -> {
                val slideResponse = (uiState as UiState.Success<SlideResponse>).data
                SlideRow(slidesResponse = slideResponse)
            }
            is UiState.Loading -> {
                LoadingScreen()
            }
            is UiState.Error -> {
                ErrorScreen()
            }
        }
        TitleWithSeeAll(
            title = "Purchase land needs",
            description = "Complete, guaranteed, and original"
        )
        ProductRow()
    }

    // Memanggil fungsi untuk mendapatkan data slide
    LaunchedEffect(Unit) {
        homeViewModel.getAllSlides()
    }
}

@Composable
fun Banner(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(R.drawable.banner),
            contentDescription = "Banner Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()
        )
        Column(
            modifier = modifier
                .padding(16.dp)
                .align(Alignment.Center)
        ) {
            Text(
                text = "Hello Akbar Maulana",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Light,
                color = Color.White
            )
            Text(
                text = "it’s a sunny day!",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = modifier.padding(bottom = 16.dp)
            )
            WeatherCard(
                card = WeatherModel(
                    R.drawable.day,
                    "25°C",
                    "Pekanbaru, ",
                    "12:00 PM",
                    "50 %",
                    "10 m/s"
                ),
                modifier = modifier
            )
        }
    }
}

@Composable
fun SlideRow(
    slidesResponse: SlideResponse,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        val slides = slidesResponse.rec
        items(slides) { slide ->
            SlideCacheUtil.cacheSlideImage(LocalContext.current, slide.photo)
            SlideItem(slide)
        }
    }
}

@Composable
fun ProductRow(
    modifier: Modifier = Modifier,

    ) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        items(FakeProductDataSource.dummyProduct, key = { it.id }) { product ->
            ProductItem(
                image = product.image,
                title = product.title,
                price = product.price
            )
        }
    }
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment =  Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Image(
            modifier = modifier.size(120.dp),
            painter = painterResource(R.drawable.loading_img),
            contentDescription = stringResource(R.string.loading)
        )
    }
}

@Composable
fun ErrorScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_connection_error), contentDescription = ""
        )
        Text(text = stringResource(R.string.loading_failed), modifier = Modifier.padding(16.dp))
    }
}
