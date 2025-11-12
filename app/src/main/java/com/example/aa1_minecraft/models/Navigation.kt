package com.example.aa1_minecraft.models

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun NavigationWrapper(modifier: Modifier = Modifier){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "general"){
        composable(route = "encantamientos"){ EncantamientoEscena(modifier, navController)}
        composable(route = "mobs"){ MobsEscena(modifier, navController)}
        composable(route = "general"){ GeneralEscena(modifier, navController)}

    }
}

