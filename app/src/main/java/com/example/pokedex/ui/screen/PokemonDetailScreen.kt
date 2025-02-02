package com.example.pokedex.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokedex.viewmodel.PokemonViewModel

@Composable
fun PokemonDetailScreen(name: String, viewModel: PokemonViewModel) {
    val pokemon by remember { viewModel.selectedPokemon }

    LaunchedEffect(name) {
        viewModel.fetchPokemonDetails(name)
    }

    pokemon?.let {
        Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
            AsyncImage(model = it.sprites.front_default, contentDescription = it.name)
            Text(text = "Name: ${it.name.replaceFirstChar { c -> c.uppercase() }}")
            Text(text = "Types: ${it.types.joinToString { type -> type.name }}")
            Text(text = "Abilities: ${it.abilities.joinToString { ability -> ability.name }}")
        }
    }
}
