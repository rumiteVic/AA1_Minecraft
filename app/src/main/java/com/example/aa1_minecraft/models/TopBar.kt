package com.example.aa1_minecraft.models


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.aa1_minecraft.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(versionActual: Float, onVersionChange: (Float) -> Unit){
    var expanded by remember {mutableStateOf(false)}
    val versiones = listOf(1.7f, 1.8f)
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Button(onClick = { expanded =!expanded }, modifier = Modifier
            .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
            .size(width = 130.dp, height = 50.dp),
            contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(0.dp)) {
            Row {
                Text(text = "Versión: ")
                Text(text = versionActual.toString())
            }
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            versiones.forEach { item ->
                DropdownMenuItem(text = { Text(text = item.toString()) }, onClick = { onVersionChange(item); expanded = false })
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        var text by remember { mutableStateOf("Buscar") }
        TextField(value = text, onValueChange = {text = it}, modifier = Modifier.fillMaxWidth())
    }
}

@Composable
fun TopTopBar(modifier: Modifier = Modifier) {
    var expanded by remember {mutableStateOf(false)}
    val desplegable = listOf("Opciones", "Idioma", "Tema")
    Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically) {
        Image(modifier = Modifier.weight(0.25f) .size(45.dp),
            painter = painterResource(id = R.drawable.plains_grass_block), contentDescription = null)
        Text(modifier = Modifier.weight(0.5f), text = "Minecraft APP", fontSize = 25.sp)
        Button(onClick = { expanded =!expanded }, modifier = Modifier
            .weight(0.25f)
            .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
            .size(width = 130.dp, height = 50.dp),
            contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(0.dp)) {
            Image(painter = painterResource(id = R.drawable.rallitas), contentDescription = null)
        }
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            desplegable.forEach { item ->
                DropdownMenuItem(text = { Text(text = item.toString()) }, onClick = { TODO(); expanded = false })
            }
        }
    }
}


