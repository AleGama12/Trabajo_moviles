package com.example.pokedex.data.model

// Datos completos de un Pokémon en una sola clase optimizada
data class Pokemon(
    val id: Int,
    val name: String,
    val height: Int,
    val weight: Int,
    val base_experience: Int,
    val types: List<Type>,
    val abilities: List<Ability>,
    val stats: List<Stat>,
    val sprites: Sprites,
    val species: Species
)

data class Type(
    val name: String
)

data class Ability(
    val name: String
)

data class Stat(
    val name: String,
    val base_stat: Int
)

data class Sprites(
    val front_default: String,
    val back_default: String,
    val front_shiny: String,
    val back_shiny: String
)

data class Species(
    val name: String,
    val url: String
)
