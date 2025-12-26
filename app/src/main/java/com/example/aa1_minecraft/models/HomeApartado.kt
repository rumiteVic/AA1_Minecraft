package com.example.aa1_minecraft.models

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.aa1_minecraft.clases.DataLoaders

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeEscena(modifier: Modifier = Modifier, navController: NavController, onThemeToggle: () -> Unit, Username: String){
    val listaSkins = DataLoaders().loadSkinsInfo()
    val user = Username

}