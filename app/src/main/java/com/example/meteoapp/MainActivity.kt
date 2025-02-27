package com.example.meteoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.foundation.layout.size
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.meteoapp.network.Meteo
import com.example.meteoapp.ui.theme.MeteoAppTheme
import com.example.meteoapp.ui.theme.viewModel.MeteoUiState
import com.example.meteoapp.ui.theme.viewModel.MeteoViewModel

class MainActivity : ComponentActivity() {
    val meteoViewModel: MeteoViewModel = MeteoViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeteoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val state = meteoViewModel.meteoUiState
                    when (state) {
                        MeteoUiState.Error -> Text(text = "Error")
                        MeteoUiState.Loading -> LoadingScreen(Modifier.padding(innerPadding))
                        is MeteoUiState.Success -> Meteo(state.meteo, Modifier.padding(innerPadding))
                    }
                    /*Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )*/
                }
            }
        }
    }
}


@Composable
fun Meteo(meteo: Meteo, modifier: Modifier = Modifier) {
    Text(
        text = "Aujourd'hui, il fait ${meteo.current.temperature} ${meteo.currentUnit.temperature}",
        modifier = modifier
    )
}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier) {
    Image(
        modifier = modifier.size(200.dp),
        painter = painterResource(R.drawable.loading_img),
        contentDescription = stringResource(R.string.loading)
    )
}