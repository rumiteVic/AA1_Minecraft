package com.example.aa1_minecraft.models

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.aa1_minecraft.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomBar(modifier: Modifier = Modifier, navController: NavController){
    Row (modifier = Modifier
        .fillMaxWidth()
        .background(MaterialTheme.colorScheme.secondary),
        horizontalArrangement = Arrangement.SpaceEvenly,
        ){
        Button(onClick = { navController.navigate("home") },
            modifier = Modifier
                .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
                .padding(2.dp)
                .border(BorderStroke(4.dp, MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)))
                .weight(1f, true),
            contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(0.dp)) {
            Image(painter = painterResource(id = R.drawable.image),
                contentDescription = null,
                modifier = Modifier
                .size(width = 75.dp, height = 75.dp),
                alignment = Alignment.Center
            )


        }
        Button(onClick = { navController.navigate("general") },
            modifier = Modifier
                .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
                .padding(2.dp)
                .border(BorderStroke(4.dp, MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)))
                .weight(1f, true),
            contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(0.dp)) {
            Image(painter = painterResource(id = R.drawable.image2),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 75.dp, height = 75.dp),
                alignment = Alignment.Center
            )
        }
        Button(onClick = { navController.navigate("general") },
            modifier = Modifier
                .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
                .padding(2.dp)
                .border(BorderStroke(4.dp, MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)))
                .weight(1f, true),
            contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(0.dp)) {
            Image(painter = painterResource(id = R.drawable.image3),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 75.dp, height = 75.dp),
                alignment = Alignment.Center
            )
        }
        Button(onClick = { navController.navigate("crafteos") },
            modifier = Modifier
                .border(BorderStroke(2.dp, MaterialTheme.colorScheme.inverseSurface))
                .padding(2.dp)
                .border(BorderStroke(4.dp, MaterialTheme.colorScheme.onTertiaryContainer.copy(alpha = 0.75f)))
                .weight(1f, true),
            contentPadding = PaddingValues(top = 3.dp, bottom = 3.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary),
            shape = RoundedCornerShape(0.dp)) {
            Image(painter = painterResource(id = R.drawable.mesa_crafteo),
                contentDescription = null,
                modifier = Modifier
                    .size(width = 75.dp, height = 75.dp),
                alignment = Alignment.Center
            )
        }


    }
}