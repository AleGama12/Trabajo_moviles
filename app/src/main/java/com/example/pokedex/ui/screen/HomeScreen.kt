package com.example.pokedex.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    val types = listOf("fire", "water", "grass", "electric", "rock", "ground", "psychic")
    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        types.forEach { type ->
            Button(
                onClick = { navController.navigate("list/$type") },
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text(text = type.replaceFirstChar { it.uppercase() })
            }
        }
    }
}
