package com.example.aa1_minecraft.models

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun NavigationWrapper(modifier: Modifier = Modifier, onThemeToggle: () -> Unit) {
    var version by remember { mutableStateOf(1.7f) }
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "login") {
        composable(route = "login") {
            LoginScreen(
                modifier,
                navController,
                versionActual = version,
                onVersionChange = { version = it },
                onThemeToggle = onThemeToggle
            )
        }
        composable(route = "encantamientos") {
            EncantamientoEscena(
                modifier,
                navController,
                versionActual = version,
                onVersionChange = { version = it },
                onThemeToggle = onThemeToggle)
        }
        composable(route = "mobs") {
            MobsEscena(
                modifier,
                navController,
                versionActual = version,
                onVersionChange = { version = it },
                onThemeToggle = onThemeToggle)
        }
        composable(route = "Biomas") {
            BiomasEscena(
                modifier,
                navController,
                versionActual = version,
                onVersionChange = { version = it },
                onThemeToggle = onThemeToggle)
        }
        composable(route = "general") {
            GeneralEscena(
                modifier,
                navController,
                versionActual = version,
                onVersionChange = { version = it },
                onThemeToggle = onThemeToggle)
        }
        composable(route = "crafteos") {
            CrafteosApartado(
                modifier,
                navController,
                versionActual = version,
                onVersionChange = { version = it },
                onThemeToggle = onThemeToggle)
        }

    }
}

