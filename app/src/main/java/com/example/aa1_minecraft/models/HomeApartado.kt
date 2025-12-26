package com.example.aa1_minecraft.models

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
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aa1_minecraft.clases.DataLoaders
import com.example.aa1_minecraft.classes.Crafteos
import com.example.aa1_minecraft.classes.SkinsInfo
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeEscena(modifier: Modifier = Modifier, navController: NavController, onThemeToggle: () -> Unit, Username: String){
    val listaSkins = DataLoaders().loadSkinsInfo()
    val user = Username
    var skinSeleccionada by remember {
        mutableStateOf(
            listaSkins.find { it.name == "Steve" }
        )
    }
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            BottomBar( navController = navController)
        })
    { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            TopTopBar(modifier = Modifier.height(16.dp),0, onThemeToggle = onThemeToggle)
            Spacer(modifier = Modifier.height(16.dp))
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                item{
                    Text(text = user, fontSize = 50.sp)

                    SkinConcreta(skinSeleccionada)
                    Button(
                        onClick = {
                            val newIndex = Random.nextInt(listaSkins.size)
                            skinSeleccionada = listaSkins[newIndex]
                        },
                        modifier = Modifier
                            .border(BorderStroke(4.dp, MaterialTheme.colorScheme.outline))
                            .size(width = 100.dp, height = 100.dp),
                        contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        ),
                        shape = RoundedCornerShape(0.dp)
                    ) {
                        Text(text = "Change", fontSize = 20.sp)
                    }

                }
            }
        }
    }
}

@Composable
fun SkinConcreta(skin: SkinsInfo?, modifier: Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally){
        Box(modifier = Modifier

            .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
            .border(
                BorderStroke(
                    4.dp,
                    MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                )

            )
        ){
        }
        Spacer(modifier = Modifier.width(16.dp))
        Box(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .fillMaxWidth()
            .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
            .background(MaterialTheme.colorScheme.secondary)
            .border(
                BorderStroke(
                    4.dp,
                    MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                )

            )
        ) {
            Image(
                painter = painterResource(id = skin!!.imageRes),
                contentDescription = null,
                modifier = Modifier.size(300.dp).padding(4.dp).align(Alignment.Center)
            )
        }

    }
}