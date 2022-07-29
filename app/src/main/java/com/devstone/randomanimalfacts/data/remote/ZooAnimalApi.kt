package com.devstone.randomanimalfacts.data.remote

import com.devstone.randomanimalfacts.data.model.AnimalFact
import retrofit2.Response
import retrofit2.http.GET

interface ZooAnimalApi {

    @GET("/animals /rand")
    suspend fun getAnimalFact(): Response<AnimalFact>

}