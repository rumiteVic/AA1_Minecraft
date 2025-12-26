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
import com.example.aa1_minecraft.clases.Encantamientos
import com.example.aa1_minecraft.clases.Mobs
import com.example.aa1_minecraft.classes.Biomas
import com.example.aa1_minecraft.classes.BiomasDisponibles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BiomasEscena(
    modifier: Modifier = Modifier,
    navController: NavController,
    versionActual: Float,
    onVersionChange: (Float) -> Unit,
    onThemeToggle: () -> Unit
) {
    val listaBiomas = DataLoaders().loadBiomasInfo()
    var biomaSeleccionado by remember { mutableStateOf<Biomas?>(null) }
    val biomasFiltrados = listaBiomas.filter { it.versionImplementada <= versionActual }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = { BottomBar(navController = navController) }
    ) { innerPadding ->

        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {

            TopTopBar(modifier = Modifier.height(16.dp), 1, onThemeToggle = onThemeToggle)
            Spacer(modifier = Modifier.height(16.dp))

            TopBar(versionActual = versionActual, onVersionChange = onVersionChange)
            Spacer(modifier = Modifier.height(16.dp))

            if (biomaSeleccionado != null) {
                BiomaConcreto(bioma = biomaSeleccionado!!)
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                ) {

                    for (i in 0..(biomasFiltrados.size - 1) step 2) {
                        item {
                            Row(
                                modifier = Modifier.fillMaxWidth()
                                    .padding(horizontal = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {

                                BiomaBoton(biomasFiltrados[i]) {
                                    biomaSeleccionado = biomasFiltrados[i]
                                }

                                if (i + 1 < biomasFiltrados.size) {
                                    BiomaBoton(biomasFiltrados[i + 1]) {
                                        biomaSeleccionado = biomasFiltrados[i + 1]
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
}


@Composable
fun BiomaBoton(bioma: Biomas, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier
            .border(BorderStroke(4.dp, MaterialTheme.colorScheme.outline))
            .size(width = 150.dp, height = 150.dp),
        contentPadding = PaddingValues(0.dp),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        shape = RoundedCornerShape(0.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            Image(
                painter = painterResource(id = bioma.imageResourceID),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(MaterialTheme.colorScheme.onSecondaryContainer.copy(alpha = 0.75f))
            ) {
                Text(
                    text = bioma.name.nombre,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                    modifier = Modifier.fillMaxWidth().padding(vertical = 2.dp)
                )
            }
        }
    }
}

@Composable
fun BiomaConcreto(bioma: Biomas, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {

        Row(modifier = Modifier.padding(16.dp)) {

            Image(
                painter = painterResource(id = bioma.imageResourceID),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = bioma.name.nombre)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = bioma.description)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tabla de información
        InfoRow("Tipo de bioma", bioma.tipoBioma.nombre)
        InfoRow("Biomas relacionados", bioma.tipoBioma.biomas.joinToString { it.nombre })
        InfoRow("Versión introducida", bioma.versionImplementada.toString())
    }
}

@Composable
fun InfoRow(title: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
            .padding(8.dp)
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(title, color = MaterialTheme.colorScheme.onSecondary)
        }
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Text(value, color = MaterialTheme.colorScheme.onSecondary)
        }
    }
}
