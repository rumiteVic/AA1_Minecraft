package com.example.aa1_minecraft.models


import android.R.attr.value
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
import androidx.compose.material3.TextField
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
import com.example.aa1_minecraft.classes.Crafteos
import kotlin.random.Random

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CrafteosApartado(modifier: Modifier = Modifier, navController: NavController, versionActual: Float, onVersionChange: (Float) -> Unit, onThemeToggle: () -> Unit) {
    val listaCrafteos = DataLoaders().loadCrafteosInfo()
    val crafteosFinal = listaCrafteos.filter { it.versionImplementada <= versionActual }
    var crafteoSeleccionado by remember {
        mutableStateOf(
            crafteosFinal.find { it.name == "Mesa de crafteo" }
        )
    }
    var query by remember { mutableStateOf("") }
    val listaFiltrada = crafteosFinal.filter { it.name.contains(query, ignoreCase = true) }

    Scaffold(
        containerColor = MaterialTheme.colorScheme.background,
        bottomBar = {
            BottomBar(navController = navController)
        }
    ){ innerPadding ->
        Column(modifier = modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(dimensionResource(id = R.dimen.dimendp16)),
            horizontalAlignment = Alignment.CenterHorizontally){
            TopTopBar(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)),4, onThemeToggle = onThemeToggle)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)))
            TopBar(versionActual = versionActual, onVersionChange = onVersionChange)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)))
            CrafteoConcreto(crafteo = crafteoSeleccionado!!)
            Button(onClick = { val nuevoIndice = Random.nextInt(crafteosFinal.size)
                crafteoSeleccionado = crafteosFinal[nuevoIndice]}, modifier = Modifier
                .border(
                    BorderStroke(
                        dimensionResource(id = R.dimen.dimendp4),
                        MaterialTheme.colorScheme.outline
                    )
                )
                .size(width = dimensionResource(id = R.dimen.dimendp100), height = dimensionResource(id = R.dimen.dimendp100)),
                contentPadding = PaddingValues(top = dimensionResource(id = R.dimen.dimendp3), bottom = dimensionResource(id = R.dimen.dimendp3)),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                shape = RoundedCornerShape(dimensionResource(id = R.dimen.dimendpnada))
            ){
                Text(text = "Craft", style = MaterialTheme.typography.bodyLarge)
            }
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)))
            TextField(
                value = query,
                onValueChange = { texto ->
                    query = texto
                    crafteoSeleccionado = listaFiltrada.firstOrNull()
                },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Buscar recetas") }
            )
        }
    }
}


@Composable
fun CrafteoConcreto(crafteo: Crafteos, modifier: Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(dimensionResource(id = R.dimen.dimendp16)),
    horizontalAlignment = Alignment.CenterHorizontally){
        Box(modifier = Modifier

            .border(BorderStroke(dimensionResource(id = R.dimen.dimendp2), MaterialTheme.colorScheme.inverseSurface))
            .border(
                BorderStroke(
                    dimensionResource(id = R.dimen.dimendp4),
                    MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                )

        )
        ){
                Text(
                    text = crafteo.name, modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.secondary)
                        .padding(dimensionResource(id = R.dimen.dimendp4)),

                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
                Spacer(modifier = Modifier.width(dimensionResource(id = R.dimen.dimendp16)))
        Box(modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .fillMaxWidth()
            .border(BorderStroke(dimensionResource(id = R.dimen.dimendp2), MaterialTheme.colorScheme.inverseSurface))
            .background(MaterialTheme.colorScheme.secondary)
            .border(
                BorderStroke(
                    dimensionResource(id = R.dimen.dimendp4),
                    MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                )

            )
        ) {
            Image(
                painter = painterResource(id = crafteo.imageResourceID),
                contentDescription = null,
                modifier = Modifier.size(dimensionResource(id = R.dimen.dimendp150)).padding(dimensionResource(id = R.dimen.dimendp4)).align(Alignment.Center)
            )
        }
        if(crafteo.description != null) {
            Box(modifier = Modifier

                .border(BorderStroke(dimensionResource(id = R.dimen.dimendp2), MaterialTheme.colorScheme.inverseSurface))
                .border(
                    BorderStroke(
                        dimensionResource(id = R.dimen.dimendp4),
                        MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                    )

                )
            ) {
                Text(
                    text = crafteo.description, modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.secondary)
                        .padding(dimensionResource(id = R.dimen.dimendp4)),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimaryContainer
                )
            }
        }

    }
} 