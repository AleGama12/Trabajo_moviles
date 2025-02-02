package com.example.pokedex.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import coil.compose.rememberImagePainter
import com.example.pokedex.viewmodel.PokemonViewModel

@Composable
fun PokemonDetailScreen(name: String, viewModel: PokemonViewModel) {
    LaunchedEffect(name) {
        viewModel.fetchPokemonDetails(name)
    }
    val pokemon = viewModel.selectedPokemon.value
    pokemon?.let {
        Column {
            Image(painter = rememberImagePainter(it.sprites.front_default), contentDescription = it.name)
            Text(text = "Name: ${it.name.capitalize()}")
            Text(text = "Types: ${it.types.joinToString { type -> type.type.name }}")
            Text(text = "Abilities: ${it.abilities.joinToString { ability -> ability.ability.name }}")
        }
    }
}
