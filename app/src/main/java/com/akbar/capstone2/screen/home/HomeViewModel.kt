package com.akbar.capstone2.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akbar.capstone2.common.UiState
import com.akbar.capstone2.model.slide.SlideResponse
import com.akbar.capstone2.network.ApiHelper
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class HomeViewModel : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<SlideResponse>> =
        MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<SlideResponse>>
        get() = _uiState

    init {
        getAllSlides()
    }

    fun getAllSlides() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            try {
                val listResult = withContext(Dispatchers.IO) {
                    ApiHelper.getApiService().getSlides()
                }
                _uiState.value = UiState.Success(listResult)
            } catch (e: IOException) {
                _uiState.value = UiState.Error("An IO exception occurred")
            } catch (e: HttpException) {
                _uiState.value = UiState.Error("An HTTP exception occurred")
            }
        }
    }
}
