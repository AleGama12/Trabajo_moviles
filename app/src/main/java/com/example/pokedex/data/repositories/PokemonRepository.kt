package com.example.pokedex.data.repositories

import com.example.pokedex.data.model.Pokemon

class PokemonRepository {
    suspend fun getPokemonByType(type: String): List<Pokemon> {
        val response = RetrofitInstance.api.getPokemonByType(type)
        return response.Pokemon.map { it.pokemon }
    }

    suspend fun getPokemonDetails(name: String): Pokemon {
        return RetrofitInstance.api.getPokemonDetails(name)
    }
}
