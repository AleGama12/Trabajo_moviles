package com.example.pokedex.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    val types = listOf("fire", "water", "grass", "electric", "rock", "ground", "psychic")
    Column {
        types.forEach { type ->
            Button(onClick = { navController.navigate("list/$type") }) {
                Text(text = type.capitalize())
            }
        }
    }
}
