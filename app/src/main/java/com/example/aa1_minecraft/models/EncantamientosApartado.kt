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
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aa1_minecraft.clases.DataLoaders
import com.example.aa1_minecraft.clases.Encantamientos

@OptIn(ExperimentalMaterial3Api::class, ExperimentalAnimationApi::class)
@Composable
fun EncantamientoEscena(modifier: Modifier = Modifier, navController: NavController, versionActual: Float, onVersionChange: (Float) -> Unit, onThemeToggle: () -> Unit) {
    val listaEncantamientos = DataLoaders().loadEncantamientosInfo()
    var encantamientoSelecciodo by remember { mutableStateOf<Encantamientos?>(null) }
    val encantamientosFinal = listaEncantamientos.filter { it.versionImplementada <= versionActual }


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
            TopTopBar(modifier = Modifier.height(16.dp), 1, onThemeToggle = onThemeToggle)
            Spacer(modifier = Modifier.height(16.dp))
            TopBar(versionActual = versionActual, onVersionChange = onVersionChange)
            Spacer(modifier = Modifier.height(16.dp))
            AnimatedContent(
                targetState = encantamientoSelecciodo,
                transitionSpec = {
                    slideInHorizontally { fullWidth -> fullWidth } + fadeIn() with
                            slideOutHorizontally { fullWidth -> -fullWidth } + fadeOut()
                }
            ){encantamiento ->
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
                                        onClick = { encantamientoSelecciodo = encantamientosFinal[i] },
                                        modifier = Modifier
                                            .border(
                                                BorderStroke(
                                                    4.dp,
                                                    MaterialTheme.colorScheme.outline
                                                )
                                            )
                                            .size(width = 150.dp, height = 150.dp),
                                        contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
                                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                                        shape = RoundedCornerShape(0.dp)
                                    ) {
                                        Box(modifier = Modifier.fillMaxSize()) {
                                            Image(
                                                painter = painterResource(id = encantamientosFinal[i].imageResourceID),
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
                                                    text = encantamientosFinal[i].encantamiento.nombre,
                                                    modifier = Modifier
                                                        .fillMaxWidth()
                                                        .padding(4.dp)
                                                        .background(MaterialTheme.colorScheme.onSecondaryContainer),
                                                    textAlign = TextAlign.Center,
                                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                                )
                                            }
                                        }
                                    }
                                    if (i + 1 < encantamientosFinal.size) {
                                        Button(
                                            onClick = { encantamientoSelecciodo = encantamientosFinal[i + 1] },
                                            modifier = Modifier
                                                .border(
                                                    BorderStroke(
                                                        4.dp,
                                                        MaterialTheme.colorScheme.outline
                                                    )
                                                )
                                                .size(width = 150.dp, height = 150.dp),
                                            contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
                                            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                                            shape = RoundedCornerShape(0.dp)
                                        ) {
                                            Box(modifier = Modifier.fillMaxSize()) {
                                                Image(
                                                    painter = painterResource(id = encantamientosFinal[i + 1].imageResourceID),
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
                                                        text = encantamientosFinal[i + 1].encantamiento.nombre,
                                                        modifier = Modifier
                                                            .fillMaxWidth()
                                                            .padding(4.dp)
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
}

@Composable
fun EncantamientoConcreto(encantamiento: Encantamientos, modifier: Modifier = Modifier){
    var isPressed by remember { mutableStateOf(false) }

    val animation by animateFloatAsState(
        targetValue = if (isPressed) 1.1f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        )
    )
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {

        Row(modifier = Modifier.padding(16.dp)) {
            IconButton (
                onClick = {
                    isPressed = !isPressed}, modifier = Modifier.size(90.dp)){
                Image(
                    painter = painterResource(id = encantamiento.imageResourceID),
                    contentDescription = null,
                    modifier = Modifier.size(150.dp).scale(animation)
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = encantamiento.encantamiento.nombre, textAlign = TextAlign.Center, fontSize = 22.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = encantamiento.efecto, textAlign = TextAlign.Center)
            }
        }
        Column(modifier = Modifier
            .padding(6.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            Row (modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .weight(1f), horizontalArrangement = Arrangement.Center){
                Box(modifier = Modifier
                    .weight(1f)
                    .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
                    .padding(2.dp)
                    .border(
                        BorderStroke(
                            4.dp,
                            MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                        )
                    )
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    Text(
                        text = "Nivel máximo",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
                    .padding(2.dp)
                    .border(
                        BorderStroke(
                            4.dp,
                            MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                        )
                    )
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center){
                    Text(
                        text = encantamiento.nivelMaximo.toString(),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .weight(1f), horizontalArrangement = Arrangement.Center) {
                Box(modifier = Modifier
                    .weight(1f)
                    .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
                    .padding(2.dp)
                    .border(
                        BorderStroke(
                            4.dp,
                            MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                        )
                    )
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    Text(
                        text = "Peso encantamiento",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
                    .padding(2.dp)
                    .border(
                        BorderStroke(
                            4.dp,
                            MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                        )
                    )
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    Text(
                        text = encantamiento.pesoEncantamiento.toString(),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .weight(1f), horizontalArrangement = Arrangement.Center) {
                Box(modifier = Modifier
                    .weight(1f)
                    .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
                    .padding(2.dp)
                    .border(
                        BorderStroke(
                            4.dp,
                            MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                        )
                    )
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    Text(
                        text = "Se encuentra \nsolo en tesoros",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondary,

                    )
                }
                if (encantamiento.halladoEnTesoro) {
                    Box(modifier = Modifier
                        .weight(1f)
                        .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
                        .padding(2.dp)
                        .border(
                            BorderStroke(
                                4.dp,
                                MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                            )
                        )
                        .fillMaxSize(),
                        contentAlignment = Alignment.Center) {
                        Text(text = "Sí", fontSize = 20.sp, textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onSecondary,
                            modifier = Modifier
                                .padding(10.dp))
                    }
                } else {
                    Box(modifier = Modifier
                        .weight(1f)
                        .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
                        .padding(2.dp)
                        .border(
                            BorderStroke(
                                4.dp,
                                MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                            )
                        )
                        .fillMaxSize(),
                        contentAlignment = Alignment.Center){
                        Text(text = "No", fontSize = 20.sp, textAlign = TextAlign.Center,
                            color = MaterialTheme.colorScheme.onSecondary,
                            modifier = Modifier
                                .padding(10.dp))
                    }
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .background(MaterialTheme.colorScheme.secondary)
                .weight(1f), horizontalArrangement = Arrangement.Center) {
                Box(modifier = Modifier
                    .weight(1f)
                    .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
                    .padding(2.dp)
                    .border(
                        BorderStroke(
                            4.dp,
                            MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                        )
                    )
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    Text(
                        text = "Disponible en los siguientes items",
                        fontSize = 15.sp,
                        textAlign = TextAlign.Center,
                        color = MaterialTheme.colorScheme.onSecondary,
                        modifier = Modifier
                            .padding(10.dp)
                    )
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
                    .padding(2.dp)
                    .border(
                        BorderStroke(
                            4.dp,
                            MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)
                        )
                    )
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    LazyColumn {
                        item{
                            for (item in encantamiento.encantamiento.itemsCompatibles) {
                                Text(text = item.nombre, fontSize = 20.sp, textAlign = TextAlign.Center,
                                    color = MaterialTheme.colorScheme.onSecondary,
                                    modifier = Modifier
                                        .padding(5.dp))
                                Spacer(modifier = Modifier.height(2.dp))
                            }
                        }

                    }
                }
            }

        }
    }
}


@Preview
@Composable
fun Test(){
    var data = DataLoaders()
    EncantamientoConcreto(data.loadEncantamientosInfo()[3])

}
