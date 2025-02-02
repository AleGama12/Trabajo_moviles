package com.example.pokedex.data.repositories

import com.example.pokedex.data.repositories.RetrofitInstance
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.data.model.TypeResponse

class PokemonRepository {
    suspend fun getPokemonByType(type: String): List<Pokemon> {
        return RetrofitInstance.api.getPokemonByType(type)
    }

    suspend fun getPokemonDetails(name: String): Pokemon {
        return RetrofitInstance.api.getPokemonDetails(name)
    }
}
