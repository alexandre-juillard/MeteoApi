package com.example.meteoapp.ui.theme.viewModel

import android.util.Log
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
        Log.d("Debug", "init")
    }

    fun getMeteo() {
        Log.d("Debug", "getMeteo()")
        viewModelScope.launch {
            try {
                val response = MeteoApi.retrofitService.getMeteo(45.75, 4.85)
                Log.d("Response", "$response")
                meteoUiState = MeteoUiState.Success(response)
            } catch (e: IOError) {
                meteoUiState = MeteoUiState.Error
                Log.d("Response", "${e.message}")
            }

        }
    }
}