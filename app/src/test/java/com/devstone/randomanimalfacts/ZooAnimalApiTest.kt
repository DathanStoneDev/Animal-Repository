package com.devstone.randomanimalfacts

import com.devstone.randomanimalfacts.data.model.AnimalFact
import com.devstone.randomanimalfacts.data.remote.ZooAnimalApi
import com.devstone.randomanimalfacts.util.Constants
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.*
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ZooAnimalApiTest {

    private lateinit var api: ZooAnimalApi

    @Before
    fun createApi() {
        api = Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ZooAnimalApi::class.java)
    }

    @Test
    fun `should get https status OK success (200)` () = runBlocking {
        val response = api.getAnimalFact()
        assertThat(response.code(), equalTo(200))
    }

    @Test
    fun `should map json to AnimalFact object` () = runBlocking {
        val response = api.getAnimalFact()
        if (response.isSuccessful) {
            val animalFact = response.body()
            assertThat(animalFact, isA(AnimalFact::class.java))
            assertThat(animalFact, `is`(notNullValue()))
        }
    }
}