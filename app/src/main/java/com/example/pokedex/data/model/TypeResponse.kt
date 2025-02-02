package com.example.pokedex.data.model

data class TypeResponse(
    val pokemon: List<PokemonEntry> // 📌 Debe ser una lista de objetos `PokemonEntry`
)

data class PokemonEntry(
    val pokemon: PokemonBasic // 📌 La API devuelve `pokemon` dentro de `PokemonEntry`
)

data class PokemonBasic(
    val name: String,
    val url: String
)
