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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aa1_minecraft.clases.DataLoaders

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneralEscena(modifier: Modifier = Modifier, navController: NavController, versionActual: Float, onVersionChange: (Float) -> Unit, onThemeToggle: () -> Unit) {
    val listaBiblio = DataLoaders().loadBibliotecaInfo()
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
                .padding(dimensionResource(id = R.dimen.dimendp16))
        ) {
            TopTopBar(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)),3, onThemeToggle = onThemeToggle)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)))
            TopBar(versionActual = versionActual, onVersionChange = onVersionChange)
            Spacer(modifier = Modifier.height(dimensionResource(id = R.dimen.dimendp16)))
            LazyColumn(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dimensionResource(id = R.dimen.dimendp8))
            ) {
                for (i in 0..(listaBiblio.size - 1) step 2) {
                    item {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = dimensionResource(id = R.dimen.dimendp8)),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Button(
                                onClick = { navController.navigate(listaBiblio[i].route) },
                                modifier = Modifier
                                    .border(
                                        BorderStroke(
                                            dimensionResource(id = R.dimen.dimendp4),
                                            MaterialTheme.colorScheme.outline
                                        )
                                    )
                                    .size(width = dimensionResource(id = R.dimen.dimendp150), height = dimensionResource(id = R.dimen.dimendp150)),
                                contentPadding = PaddingValues(top = dimensionResource(id = R.dimen.dimendp3), bottom = dimensionResource(id = R.dimen.dimendp3)),
                                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                                shape = RoundedCornerShape(dimensionResource(id = R.dimen.dimendpnada))
                            ) {
                                Box(modifier = Modifier.fillMaxSize()) {
                                    Image(
                                        painter = painterResource(id = listaBiblio[i].imageRes),
                                        contentDescription = null,
                                        modifier = Modifier.fillMaxSize()
                                    )
                                    Box(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .align(Alignment.BottomCenter)
                                            .padding(bottom = dimensionResource(id = R.dimen.dimendp4))
                                    ) {
                                        Text(
                                            text = listaBiblio[i].title,
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .padding(dimensionResource(id = R.dimen.dimendp4))
                                                .background(MaterialTheme.colorScheme.onSecondaryContainer),
                                            textAlign = TextAlign.Center,
                                            color = MaterialTheme.colorScheme.onPrimaryContainer
                                        )
                                    }
                                }
                            }
                            if (i + 1 < listaBiblio.size) {
                                Button(
                                    onClick = { navController.navigate(listaBiblio[i + 1].route) },
                                    modifier = Modifier
                                        .border(
                                            BorderStroke(
                                                dimensionResource(id = R.dimen.dimendp4),
                                                MaterialTheme.colorScheme.outline
                                            )
                                        )
                                        .size(width = dimensionResource(id = R.dimen.dimendp150), height = dimensionResource(id = R.dimen.dimendp150)),
                                    contentPadding = PaddingValues(top = dimensionResource(id = R.dimen.dimendp3), bottom = dimensionResource(id = R.dimen.dimendp3)),
                                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primaryContainer),
                                    shape = RoundedCornerShape(dimensionResource(id = R.dimen.dimendpnada))
                                ) {
                                    Box(modifier = Modifier.fillMaxSize()) {
                                        Image(
                                            painter = painterResource(id = listaBiblio[i + 1].imageRes),
                                            contentDescription = null,
                                            modifier = Modifier.fillMaxSize()
                                        )
                                        Box(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .align(Alignment.BottomCenter)
                                                .padding(bottom = dimensionResource(id = R.dimen.dimendp4))
                                        ) {
                                            Text(
                                                text = listaBiblio[i + 1].title,
                                                modifier = Modifier
                                                    .fillMaxWidth()
                                                    .padding(dimensionResource(id = R.dimen.dimendp4))
                                                    .background(MaterialTheme.colorScheme.onSecondaryContainer),
                                                textAlign = TextAlign.Center,
                                                color = MaterialTheme.colorScheme.onPrimaryContainer
                                            )
                                        }
                                    }
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

