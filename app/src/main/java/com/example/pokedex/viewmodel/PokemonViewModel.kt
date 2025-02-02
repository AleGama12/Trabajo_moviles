package com.example.pokedex.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokedex.data.repositories.PokemonRepository
import com.example.pokedex.data.model.Pokemon
import kotlinx.coroutines.launch

class PokemonViewModel : ViewModel() {
    private val repository = PokemonRepository()
    val pokemonList = mutableStateOf<List<Pokemon>>(emptyList())
    val selectedPokemon = mutableStateOf<Pokemon?>(null)

    fun fetchPokemonByType(type: String) {
        viewModelScope.launch {
            pokemonList.value = repository.getPokemonByType(type)
        }
    }

    fun fetchPokemonDetails(name: String) {
        viewModelScope.launch {
            selectedPokemon.value = repository.getPokemonDetails(name)
        }
    }
}
