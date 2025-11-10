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
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.unit.sp
import com.example.aa1_minecraft.R
import com.example.aa1_minecraft.clases.DataLoaders
import com.example.aa1_minecraft.clases.Encantamientos

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EncantamientoEscena(modifier: Modifier = Modifier) {
    val listaEncantamientos = DataLoaders().loadEncantamientosInfo()
    var encantamientoSelecciodo by remember { mutableStateOf<Encantamientos?>(null) }
    val encantamientosFinal = listaEncantamientos.filter { it.versionImplementada <= Version.version.toFloat() }


    Scaffold(
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            TopBar()
            Spacer(modifier = Modifier.height(16.dp))

            if (encantamientoSelecciodo != null) {
                EncantamientoConcreto(encantamiento = encantamientoSelecciodo!!)
            } else {
                LazyColumn(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    for (i in 0..(encantamientosFinal.size - 1) step 2) {
                        item {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(horizontal = 8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(
                                    onClick = { encantamientoSelecciodo = listaEncantamientos[i] },
                                    modifier = Modifier
                                        .border(BorderStroke(4.dp, MaterialTheme.colorScheme.outline))
                                        .size(width = 150.dp, height = 150.dp),
                                    contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                                    shape = RoundedCornerShape(0.dp)
                                ) {
                                    Box(modifier = Modifier.fillMaxSize()) {
                                        Image(
                                            painter = painterResource(id = listaEncantamientos[i].imageResourceID),
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
                                                text = listaEncantamientos[i].encantamiento.nombre,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .background(MaterialTheme.colorScheme.onSecondaryContainer),
                                                textAlign = TextAlign.Center,
                                                color = MaterialTheme.colorScheme.onPrimaryContainer
                                            )
                                        }
                                    }
                                }
                                if (i + 1 < listaEncantamientos.size) {
                                    Button(
                                        onClick = { encantamientoSelecciodo = listaEncantamientos[i + 1] },
                                        modifier = Modifier
                                            .border(BorderStroke(4.dp, MaterialTheme.colorScheme.outline))
                                            .size(width = 150.dp, height = 150.dp),
                                        contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                                        shape = RoundedCornerShape(0.dp)
                                    ) {
                                        Box(modifier = Modifier.fillMaxSize()) {
                                            Image(
                                                painter = painterResource(id = listaEncantamientos[i + 1].imageResourceID),
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
                                                    text = listaEncantamientos[i + 1].encantamiento.nombre,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .background(MaterialTheme.colorScheme.onSecondaryContainer),
                                                    textAlign = TextAlign.Center,
                                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                                )
                                            }
                                        }
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
fun EncantamientoConcreto(
    encantamiento: Encantamientos,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(8.dp))

        // Imagen + título + efecto
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = encantamiento.imageResourceID),
                contentDescription = encantamiento.encantamiento.nombre,
                modifier = Modifier.size(150.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = encantamiento.encantamiento.nombre,
                    style = MaterialTheme.typography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = encantamiento.efecto,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Grid informativo: cuatro filas, dos columnas
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            // Fila: Nivel máximo / valor
            InfoRow(label = "Nivel máximo", value = encantamiento.nivelMaximo.toString())

            // Fila: Peso encantamiento / valor
            InfoRow(label = "Peso encantamiento", value = encantamiento.pesoEncantamiento.toString())

            // Fila: ¿Solo en tesoros? / Sí/No
            InfoRow(label = "Se encuentra solo en tesoros", value = if (encantamiento.halladoEnTesoro) "Sí" else "No")

            // Fila: Items compatibles / lista
            Column(modifier = Modifier.fillMaxWidth()) {
                // Label
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(BorderStroke(1.dp, MaterialTheme.colorScheme.outline), shape = RoundedCornerShape(6.dp))
                        .background(MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(6.dp))
                        .padding(8.dp)
                ) {
                    Text(
                        text = "Disponible en los siguientes items",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .border(BorderStroke(1.dp, MaterialTheme.colorScheme.outline), shape = RoundedCornerShape(6.dp))
                        .background(MaterialTheme.colorScheme.surface, shape = RoundedCornerShape(6.dp))
                        .padding(8.dp)
                ) {
                    // Lista vertical compacta
                    LazyColumn {
                        item {
                            Column(verticalArrangement = Arrangement.spacedBy(6.dp)) {
                                encantamiento.encantamiento.itemsCompatibles.forEach { item ->
                                    Text(
                                        text = item.nombre,
                                        style = MaterialTheme.typography.bodyMedium,
                                        fontSize = 18.sp,
                                        color = MaterialTheme.colorScheme.onSurface,
                                        textAlign = TextAlign.Start,
                                        modifier = Modifier.fillMaxWidth()
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun InfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(BorderStroke(1.dp, MaterialTheme.colorScheme.outline), shape = RoundedCornerShape(6.dp))
            .background(MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(6.dp))
            .padding(6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Label caja (izquierda)
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(6.dp),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        // Value caja (derecha)
        Box(
            modifier = Modifier
                .weight(1f)
                .padding(6.dp),
            contentAlignment = Alignment.CenterEnd
        ) {
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}

