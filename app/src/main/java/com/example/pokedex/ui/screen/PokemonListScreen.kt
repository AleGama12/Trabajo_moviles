package com.example.pokedex.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.pokedex.viewmodel.PokemonViewModel

@Composable
fun PokemonListScreen(type: String, navController: NavController, viewModel: PokemonViewModel) {
    var query by remember { mutableStateOf("") }

    LaunchedEffect(type) {
        viewModel.fetchPokemonByType(type)
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        BasicTextField(
            value = query,
            onValueChange = { query = it },
            modifier = Modifier.fillMaxWidth().padding(8.dp)
        )

        LazyColumn {
            items(viewModel.pokemonList.value.filter { it.name.contains(query, ignoreCase = true) }) { pokemon ->
                Button(
                    onClick = { navController.navigate("detail/${pokemon.name}") },
                    modifier = Modifier.fillMaxWidth().padding(8.dp)
                ) {
                    Text(text = pokemon.name.replaceFirstChar { it.uppercase() })
                }
            }
        }
    }
}
