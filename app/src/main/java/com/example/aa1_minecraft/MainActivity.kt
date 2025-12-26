package com.example.aa1_minecraft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
//import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.aa1_minecraft.models.EncantamientoEscena
import com.example.aa1_minecraft.models.GeneralEscena
import com.example.aa1_minecraft.models.LoginScreen
import com.example.aa1_minecraft.models.NavigationWrapper
import com.example.compose.AA1_MinecraftTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var darkTheme by mutableStateOf(true)
        //enableEdgeToEdge()
        setContent {
            AA1_MinecraftTheme(darkTheme = darkTheme, dynamicColor = false) {
                //Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                NavigationWrapper(modifier = Modifier, onThemeToggle = {darkTheme = !darkTheme})
                //EncantamientoEscena(modifier = Modifier.padding(innerPadding))
                //}
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AA1_MinecraftTheme {
        NavigationWrapper(modifier = Modifier, onThemeToggle = {})
    }
}