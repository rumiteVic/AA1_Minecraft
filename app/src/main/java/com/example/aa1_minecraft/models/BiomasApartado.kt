package com.example.aa1_minecraft.models

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.with
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aa1_minecraft.R
import com.example.aa1_minecraft.clases.DataLoaders
import com.example.aa1_minecraft.clases.Encantamientos
import com.example.aa1_minecraft.clases.Mobs
import com.example.aa1_minecraft.classes.Biomas
import com.example.aa1_minecraft.classes.BiomasDisponibles

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
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
                .padding(dimensionResource(id = R.dimen.dimendp16))
        ) {

            TopTopBar(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)), 7, onThemeToggle = onThemeToggle)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)))

            TopBar(versionActual = versionActual, onVersionChange = onVersionChange)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)))
            AnimatedContent(
                targetState = biomaSeleccionado,
                transitionSpec = {
                    slideInHorizontally { fullWidth -> fullWidth } + fadeIn() with
                            slideOutHorizontally { fullWidth -> -fullWidth } + fadeOut()
                }
            ) { bioma ->
                if (biomaSeleccionado != null) {
                    BiomaConcreto(bioma = biomaSeleccionado!!)
                } else {
                    LazyColumn(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxWidth().padding(dimensionResource(id = R.dimen.dimendp8))
                    ) {

                        for (i in 0..(biomasFiltrados.size - 1) step 2) {
                            item {
                                Row(
                                    modifier = Modifier.fillMaxWidth()
                                        .padding(horizontal = dimensionResource(id = R.dimen.dimendp8)),
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
                                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)))
                            }
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
            .border(BorderStroke(dimensionResource(id = R.dimen.dimendp4), MaterialTheme.colorScheme.outline))
            .size(width = dimensionResource(id = R.dimen.dimendp150), height = dimensionResource(id = R.dimen.dimendp150)),
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.dimendpnada)),
        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
        shape = RoundedCornerShape(dimensionResource(id = R.dimen.dimendpnada))
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
                    modifier = Modifier.fillMaxWidth().padding(vertical = dimensionResource(id = R.dimen.dimendp2))
                )
            }
        }
    }
}

@Composable
fun BiomaConcreto(bioma: Biomas, modifier: Modifier = Modifier) {
    var isPressed by remember { mutableStateOf(false) }

    val animation by animateFloatAsState(
        targetValue = if (isPressed) 1.1f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )

    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(dimensionResource(id = R.dimen.dimendp16))
    ) {

        Row(modifier = Modifier.padding(dimensionResource(id = R.dimen.dimendp16))) {

            Image(
                painter = painterResource(id = bioma.imageResourceID),
                contentDescription = null,
                modifier = Modifier.size(dimensionResource(id = R.dimen.dimendp150))
            )
            Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.dimendp16)))

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = bioma.name.nombre, textAlign = TextAlign.Center, style = MaterialTheme.typography.titleLarge)
                Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp8)))
                Text(text = bioma.description)
            }
        }

        Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)))

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
            .height(96.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.secondary)
            , horizontalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier
            .weight(1f)
            .border(BorderStroke(dimensionResource(id = R.dimen.dimendp2), MaterialTheme.colorScheme.inverseSurface))
            .padding(dimensionResource(id = R.dimen.dimendp2))
            .border(
                BorderStroke(
                    dimensionResource(id = R.dimen.dimendp4),
                    MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                )
            )
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(text = title,
                color = MaterialTheme.colorScheme.onSecondary,
                textAlign = TextAlign.Center,
                maxLines = 2)
        }
        Box(modifier = Modifier
            .weight(1f)
            .border(BorderStroke(dimensionResource(id = R.dimen.dimendp2), MaterialTheme.colorScheme.inverseSurface))
            .padding(dimensionResource(id = R.dimen.dimendp2))
            .border(
                BorderStroke(
                    dimensionResource(id = R.dimen.dimendp4),
                    MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                )
            )
            .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            Text(value, color = MaterialTheme.colorScheme.onSecondary, textAlign = TextAlign.Center)
        }
    }
}


