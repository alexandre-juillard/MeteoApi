package com.example.meteoapp.ui.theme.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.meteoapp.network.Meteo
import com.example.meteoapp.network.MeteoApi
import kotlinx.coroutines.launch
import java.io.IOError

sealed interface MeteoUiState {
    data class Success(val meteo: Meteo) : MeteoUiState
    object Error : MeteoUiState
    object Loading : MeteoUiState
}

class MeteoViewModel: ViewModel() {
    var meteoUiState: MeteoUiState by mutableStateOf(MeteoUiState.Loading)
        private set
    init {
        getMeteo()
    }

    fun getMeteo() {
        viewModelScope.launch {
            try {
                val response = MeteoApi.retrofitService.getMeteo()
                meteoUiState = MeteoUiState.Success(response)
            } catch (e: IOError) {
                meteoUiState = MeteoUiState.Error
            }

        }
    }
}