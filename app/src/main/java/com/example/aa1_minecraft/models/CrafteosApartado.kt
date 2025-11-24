package com.example.aa1_minecraft.models


import android.R.attr.value
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
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
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrafteosApartado(modifier: Modifier = Modifier, navController: NavController, versionActual: Float, onVersionChange: (Float) -> Unit) {
    val listaCrafteos = DataLoaders().loadCrafteosInfo()
    val crafteosFinal = listaCrafteos.filter { it.versionImplementada <= versionActual }
    var crafteoSeleccionado by remember {
        mutableStateOf(
            crafteosFinal.find { it.name == "Mesa de crafteo" }
        )
    }
    val indiceAleatorio = Random.nextInt(crafteosFinal.size)
    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            BottomBar(navController = navController)
        }
    ){ innerPadding ->
        Column(modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)){
            TopTopBar(modifier = Modifier.height(16.dp),2)
            Spacer(modifier = Modifier.height(16.dp))
            TopBar(versionActual = versionActual, onVersionChange = onVersionChange)
            Spacer(modifier = Modifier.height(16.dp))
            CrafteoConcreto(crafteo = crafteoSeleccionado!!)
            Button(onClick = { val nuevoIndice = Random.nextInt(crafteosFinal.size)
                             crafteoSeleccionado = crafteosFinal[nuevoIndice]}, modifier = Modifier){
                Text(text = "Craft", fontSize = 20.sp)
            }
        }
    }
}

@Composable
fun CrafteoConcreto(crafteo: Crafteos, modifier: Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)){
        Image(painter = painterResource(id = crafteo.imageResourceID), contentDescription = null, modifier = Modifier.size(150.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = crafteo.name, modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.onSecondaryContainer),
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onPrimaryContainer)
    }
}