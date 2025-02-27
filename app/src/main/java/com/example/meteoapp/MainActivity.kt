package com.example.meteoapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.meteoapp.ui.theme.MeteoAppTheme
import com.example.meteoapp.ui.theme.viewModel.MeteoUiState
import com.example.meteoapp.ui.theme.viewModel.MeteoViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MeteoAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val meteoViewModel: MeteoViewModel = MeteoViewModel()
                    val state = meteoViewModel.meteoUiState
                    when (state) {
                        MeteoUiState.Error -> TODO()
                        MeteoUiState.Loading -> TODO()
                        is MeteoUiState.Success -> TODO()
                    }
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MeteoAppTheme {
        Greeting("Android")
    }
}