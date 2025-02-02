package com.example.pokedex.ui.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.navigation.NavController
import com.miproyecto.pokedex.viewmodel.PokemonViewModel

@Composable
fun PokemonListScreen(type: String, navController: NavController, viewModel: PokemonViewModel) {
    LaunchedEffect(type) {
        viewModel.fetchPokemonByType(type)
    }

    Column {
        var query by remember { mutableStateOf("") }
        BasicTextField(value = query, onValueChange = { query = it })

        LazyColumn {
            items(viewModel.pokemonList.value.filter { it.name.contains(query, ignoreCase = true) }) { pokemon ->
                Button(onClick = { navController.navigate("detail/${pokemon.name}") }) {
                    Text(text = pokemon.name.capitalize())
                }
            }
        }
    }
}
