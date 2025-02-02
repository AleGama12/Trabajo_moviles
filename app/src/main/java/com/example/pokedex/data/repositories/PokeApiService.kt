package com.example.pokedex.data.repositories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import com.example.pokedex.data.model.Pokemon

interface PokeApiService {
    @GET("type/{type}")
    suspend fun getPokemonByType(@Path("type") type: String): List<Pokemon>

    @GET("pokemon/{name}")
    suspend fun getPokemonDetails(@Path("name") name: String): Pokemon
}

