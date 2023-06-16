package com.akbar.capstone2.screen.market

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akbar.capstone2.common.UiState
import com.akbar.capstone2.data.ProductRepository
import com.akbar.capstone2.model.OrderProduct
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class MarketViewModel(
    private val repository: ProductRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<OrderProduct>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<OrderProduct>>>
        get() = _uiState

    private var _query by mutableStateOf("")
    val query: String
        get() = _query

    init {
        getAllProducts()
    }

    fun getAllProducts() {
        viewModelScope.launch {
            repository.getAllProduct()
                .catch { exception ->
                    _uiState.value = UiState.Error(exception.message.toString())
                }
                .collect { orderProduct ->
                    _uiState.value = UiState.Success(orderProduct)
                }
        }
    }
    fun search(newQuery: String) {
        _query = newQuery
        val searchResults = repository.searchProduct(_query)
            .sortedBy { it.product.title }
        _uiState.value = UiState.Success(searchResults)
    }
}