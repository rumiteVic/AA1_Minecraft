package com.example.aa1_minecraft.models

import com.example.aa1_minecraft.R
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
//import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralEscena(modifier: Modifier = Modifier/*, navController: NavController*/,
        onLoginButtonClick: () -> Unit) {
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            TopBar()
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Button(
                            onClick = /*navController.navigate("encantamientos")*/ onLoginButtonClick,
                            modifier = Modifier
                                .border(BorderStroke(4.dp, Color.Red))
                                .size(width = 150.dp, height = 150.dp),
                            contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                            shape = RoundedCornerShape(0.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize()) {
                                Image(
                                    painter = painterResource(R.drawable.enchanted),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize()
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.BottomCenter)
                                        .padding(bottom = 5.dp)
                                ) {
                                    Text(
                                        text = "ENCANTAMIENTOS",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(Color.Black.copy(0.75f)),
                                        textAlign = TextAlign.Center,
                                        color = Color.Green
                                    )
                                }
                            }
                        }
                        Button(
                            onClick =  /* navController.navigate("mobs") */onLoginButtonClick,
                            modifier = Modifier
                                .border(BorderStroke(4.dp, Color.Red))
                                .size(width = 150.dp, height = 150.dp),
                            contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
                            colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                            shape = RoundedCornerShape(0.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize()) {
                                Image(
                                    painter = painterResource(R.drawable.chicken),
                                    contentDescription = null,
                                    modifier = Modifier.fillMaxSize()
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.BottomCenter)
                                        .padding(bottom = 5.dp)
                                ) {
                                    Text(
                                        text = "MOBS",
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .background(Color.Black.copy(0.75f)),
                                        textAlign = TextAlign.Center,
                                        color = Color.Green
                                    )
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(16.dp))
                    }
                }
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Biblioteca(
    modifier: Modifier = Modifier,
    onLoginButtonClick: () -> Unit ){
    var encantamientos by remember { mutableStateOf(false) }
    var mobs by remember { mutableStateOf(false) }

    if (encantamientos) {
        EncantamientoEscena(modifier = Modifier.fillMaxSize())
    } else {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            GeneralEscena(
                modifier = Modifier.padding(innerPadding),
                onLoginButtonClick = { encantamientos = true }
            )
        }
    }
    if (mobs) {
        MobsEscena(modifier = Modifier.fillMaxSize())
    } else {
        Scaffold(
            containerColor = MaterialTheme.colorScheme.background
        ) { innerPadding ->
            GeneralEscena(
                modifier = Modifier.padding(innerPadding),
                onLoginButtonClick = { mobs = true }
            )
        }
    }
}

