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
import androidx.navigation.NavController
//import androidx.navigation.NavController
import com.example.aa1_minecraft.clases.DataLoaders
import com.example.aa1_minecraft.clases.Mobs

@Composable
fun MobsEscena(modifier: Modifier = Modifier, navController: NavController) {
    val listaMobs = DataLoaders().loadMobsInfo()
    var mobSelecciodo by remember { mutableStateOf<Mobs?>(null) }
    val encantamientosFinal = listaMobs.filter { it.versionImplementada <= Version.version.toFloat() }
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp)){
        Spacer(modifier = Modifier.height(16.dp))
        TopBar()
        Spacer(modifier = Modifier.height(16.dp))
        if (mobSelecciodo != null) {
            MobConcreto(mob = mobSelecciodo!!)
        } else {
            LazyColumn(verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)) {
                for (i in 0..(encantamientosFinal.size - 1) step 2) {
                    item {
                        Row(modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 8.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                            Button(onClick = { mobSelecciodo = listaMobs[i] }, modifier = Modifier
                                .border(BorderStroke(4.dp, Color.Red))
                                .size(width = 150.dp, height = 150.dp),
                                contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
                                colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                                shape = RoundedCornerShape(0.dp)) {
                                Box(modifier = Modifier.fillMaxSize()) {
                                    Image(painter = painterResource(id = listaMobs[i].imageResourceID), contentDescription = null, modifier = Modifier.fillMaxSize())
                                    Box(modifier = Modifier
                                        .fillMaxWidth()
                                        .align(Alignment.BottomCenter)
                                        .padding(bottom = 5.dp)){
                                        Text(
                                            text = listaMobs[i].name,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .background(Color.Black.copy(0.75f)),
                                            textAlign = TextAlign.Center,
                                            color = Color.Green
                                        )
                                    }
                                }
                            }
                            if(i+ 1 < listaMobs.size){
                                Button(onClick = { mobSelecciodo = listaMobs[i + 1] }, modifier = Modifier
                                    .border(BorderStroke(4.dp, Color.Red))
                                    .size(width = 150.dp, height = 150.dp),
                                    contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
                                    colors = ButtonDefaults.buttonColors(containerColor = Color.Gray),
                                    shape = RoundedCornerShape(0.dp)) {
                                    Box(modifier = Modifier.fillMaxSize()) {
                                        Image(painter = painterResource(id = listaMobs[i + 1].imageResourceID), contentDescription = null, modifier = Modifier.fillMaxSize())
                                        Box(modifier = Modifier
                                            .fillMaxWidth()
                                            .align(Alignment.BottomCenter)
                                            .padding(bottom = 5.dp)){
                                            Text(
                                                text = listaMobs[i + 1].name,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .background(Color.Black.copy(0.75f)),
                                                textAlign = TextAlign.Center,
                                                color = Color.Green
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

@Composable
fun MobConcreto(mob: Mobs, modifier: Modifier = Modifier){
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        Row(modifier = Modifier.padding(16.dp)) {
            Image(
                painter = painterResource(id = mob.imageResourceID),
                contentDescription = null,
                modifier = Modifier.size(150.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = mob.name, textAlign = TextAlign.Center, fontSize = 28.sp)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = mob.description, textAlign = TextAlign.Center)
            }
        }
        Column(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center){
            Row (modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .weight(1f), horizontalArrangement = Arrangement.Center){
                Box(modifier = Modifier
                    .weight(1f)
                    .border(BorderStroke(2.dp, Color.Red))
                    .padding(2.dp)
                    .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    Text(
                        text = "Cantidad corazones que tiene",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .border(BorderStroke(2.dp, Color.Red))
                    .padding(2.dp)
                    .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center){
                    Text(
                        text = mob.health.toString(),
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }
            if(mob.attack != null) {
                Row (modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.Gray)
                    .weight(1f), horizontalArrangement = Arrangement.Center) {
                    Box(modifier = Modifier
                        .weight(1f)
                        .border(BorderStroke(2.dp, Color.Red))
                        .padding(2.dp)
                        .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                        .fillMaxSize(),
                        contentAlignment = Alignment.Center) {
                        Text(
                            text = "Daño que hace",
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                    Box(modifier = Modifier
                        .weight(1f)
                        .border(BorderStroke(2.dp, Color.Red))
                        .padding(2.dp)
                        .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                        .fillMaxSize(),
                        contentAlignment = Alignment.Center) {
                        Text(
                            text = mob.attack.toString(),
                            fontSize = 20.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .weight(1f), horizontalArrangement = Arrangement.Center) {
                Box(modifier = Modifier
                    .weight(1f)
                    .border(BorderStroke(2.dp, Color.Red))
                    .padding(2.dp)
                    .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    Text(
                        text = "Drops que suelta al ser eliminado",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .border(BorderStroke(2.dp, Color.Red))
                    .padding(2.dp)
                    .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    Text(text = mob.itemDrop, fontSize = 20.sp, textAlign = TextAlign.Center)
                }
            }
            Row (modifier = Modifier
                .fillMaxWidth()
                .background(Color.Gray)
                .weight(1f), horizontalArrangement = Arrangement.Center) {
                Box(modifier = Modifier
                    .weight(1f)
                    .border(BorderStroke(2.dp, Color.Red))
                    .padding(2.dp)
                    .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    Text(
                        text = "Es pacífico",
                        fontSize = 20.sp,
                        textAlign = TextAlign.Center
                    )
                }
                Box(modifier = Modifier
                    .weight(1f)
                    .border(BorderStroke(2.dp, Color.Red))
                    .padding(2.dp)
                    .border(BorderStroke(4.dp, Color.Black.copy(alpha = 0.75f)))
                    .fillMaxSize(),
                    contentAlignment = Alignment.Center) {
                    Text(text = mob.pacific.nombre, fontSize = 20.sp, textAlign = TextAlign.Center)
                }
            }
        }
    }
}

