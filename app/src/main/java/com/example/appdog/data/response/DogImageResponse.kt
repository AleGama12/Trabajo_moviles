package com.example.appdog.data.response

data class DogImageResponse(
    val message: List<String>, // Lista de URLs de imágenes
    val status: String         // Estado de la respuesta (e.g., "success")
)
