package com.example.appdog.data.response

data class BreedListResponse(
    val message: Map<String, List<String>>, // Razas y subrazas
    val status: String
)