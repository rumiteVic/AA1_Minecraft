package com.example.aa1_minecraft.models

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aa1_minecraft.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(modifier: Modifier = Modifier, navController: NavController, versionActual: Float, onVersionChange: (Float) -> Unit, onThemeToggle: () -> Unit, name: String, onNameChange: (String) -> Unit) {
    var showEncantamiento by remember { mutableStateOf(false) }
    if (showEncantamiento) {
        EncantamientoEscena(
            modifier, navController, versionActual = versionActual, onVersionChange = onVersionChange, onThemeToggle = onThemeToggle
        )
    } else {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            LoginContent(
                modifier = Modifier.padding(innerPadding), navController, name,onNameChange = onNameChange
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginContent(
    modifier: Modifier = Modifier,
    navController: NavController,
    name: String,
    onNameChange: (String) -> Unit
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.dimendp16)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "MICOMPICRAFT",
            color = MaterialTheme.colorScheme.onBackground,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp40)))

        Image(
            painter = painterResource(R.drawable.plains_grass_block),
            contentDescription = null,
            modifier = Modifier
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp100)))

//        var text by remember { mutableStateOf("Username") }
        TextField(
            value = name,
            onValueChange = { onNameChange(it) },
            placeholder = { Text("Username") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colorScheme.onSurface,
                disabledTextColor = MaterialTheme.colorScheme.onSurface,
                containerColor = MaterialTheme.colorScheme.surface,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.outline
            )
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp8)))

        var secondText by remember { mutableStateOf("") }
        TextField(
            value = secondText,
            onValueChange = { secondText = it },
            placeholder = { Text("Password") },
            modifier = Modifier.fillMaxWidth(),
            colors = TextFieldDefaults.textFieldColors(
                textColor = MaterialTheme.colorScheme.onSurface,
                disabledTextColor = MaterialTheme.colorScheme.onSurface,
                containerColor = MaterialTheme.colorScheme.surface,
                focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                unfocusedIndicatorColor = MaterialTheme.colorScheme.outline
            )
        )

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)))

        Button(
            onClick = {
                navController.navigate("home")
                if (name.isEmpty()){
                    onNameChange("Steve")
                }
            },
            modifier = Modifier
                .border(BorderStroke(dimensionResource(id = R.dimen.dimendp4), MaterialTheme.colorScheme.outline))
                .size(width = dimensionResource(id = R.dimen.dimendp150), height = dimensionResource(id = R.dimen.dimendp50)),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.dimendpnada)),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Text("Login")
        }
        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)))
        Button(
            onClick = {navController.navigate("home") },
            modifier = Modifier
                .border(BorderStroke(dimensionResource(id = R.dimen.dimendp4), MaterialTheme.colorScheme.outline))
                .size(width = dimensionResource(id = R.dimen.dimendp150), height = dimensionResource(id = R.dimen.dimendp50)),
            shape = RoundedCornerShape(dimensionResource(id = R.dimen.dimendpnada)),
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer
            )
        ) {
            Text("Sign Up")
        }
    }
}