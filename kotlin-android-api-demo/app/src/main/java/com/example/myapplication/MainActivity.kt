package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFF5F5DC) // Beige color
                ) {
                    ApiCaller()
                }
            }
        }
    }
}

@Composable
fun ApiCaller(modifier: Modifier = Modifier) {
    var apiResponse by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()
    val client = OkHttpClient()

    fun callApi() {
        scope.launch(Dispatchers.IO) {
            val request = Request.Builder()
                // Use 10.0.2.2 to access localhost from the Android emulator
                .url("http://10.0.2.2:8000/ml-model")
                .build()

            try {
                val response = client.newCall(request).execute()
                val responseBody = response.body?.string()
                withContext(Dispatchers.Main) {
                    apiResponse = responseBody ?: "No response body"
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    apiResponse = "Error: ${e.message}"
                }
            }
        }
    }

    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("API Caller App", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { callApi() }) {
            Text("Call API")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = apiResponse)
    }
}

@Preview(showBackground = true)
@Composable
fun ApiCallerPreview() {
    MyApplicationTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFFF5F5DC) // Beige color
        ) {
            ApiCaller()
        }
    }
}
