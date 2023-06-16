package com.akbar.capstone2.screen.market

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.akbar.capstone2.R
import com.akbar.capstone2.common.UiState
import com.akbar.capstone2.di.Injection
import com.akbar.capstone2.model.OrderProduct
import com.akbar.capstone2.ui.ViewModelFactory
import com.akbar.capstone2.ui.component.ProductItem
import com.akbar.capstone2.ui.component.SearchBar


@Composable
fun MarketScreenLogic(
    modifier: Modifier = Modifier,
    viewModel: MarketViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository())
    ),
    navController: NavController,
    navigateToDetail: (Long) -> Unit,
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllProducts()
            }

            is UiState.Success -> {
                MarketScreen(
                    orderProduct = uiState.data,
                    modifier = modifier,
                    navigateToDetail = navigateToDetail,
                    searchQuery = viewModel.query,
                    onSearchQueryChange = viewModel::search,
                    navController = navController
                )
            }

            is UiState.Error -> {}
        }
    }
}

@Composable
fun MarketScreen(
    orderProduct: List<OrderProduct>,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit,
    searchQuery: String,
    onSearchQueryChange: (String) -> Unit,
    navController: NavController

) {
    Column {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
        ) {
            Card(
                modifier
                    .padding(start = 16.dp)
                    .clip(RoundedCornerShape(100.dp))
                    .background(MaterialTheme.colorScheme.onPrimary)
                    .clickable {navController.navigate("cart")}
            ) {
                Icon(
                    tint = MaterialTheme.colorScheme.primary,
                    imageVector = Icons.Default.ShoppingCart,
                    contentDescription = stringResource(R.string.menu_cart),
                    modifier = Modifier
                        .padding(16.dp)

                )
            }
            SearchBar(
                query = searchQuery,
                onQueryChange = onSearchQueryChange,
            )
        }

        LazyVerticalGrid(
            columns = GridCells.Adaptive(160.dp),
            contentPadding = PaddingValues(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            items(orderProduct) { data ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween,
                    modifier = modifier.fillMaxWidth()
                ) {
                    ProductItem(
                        image = data.product.image,
                        title = data.product.title,
                        price = data.product.price,
                        modifier = Modifier.clickable {
                            navigateToDetail(data.product.id)
                        }
                    )
                }
            }
        }
    }

}