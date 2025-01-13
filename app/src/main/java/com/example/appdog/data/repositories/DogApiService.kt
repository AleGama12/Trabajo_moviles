package com.example.appdog.data.repositories

import com.example.appdog.data.response.BreedListResponse
import com.example.appdog.data.response.DogImageResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface DogApiService {
    @GET("breed/{breed}/images")
    suspend fun getImagesForBreed(@Path("breed") breed: String): DogImageResponse

    @GET("breeds/list/all")
    suspend fun getBreedList(): BreedListResponse
}

