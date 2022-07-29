package com.devstone.randomanimalfacts.data.local

import com.devstone.randomanimalfacts.data.model.AnimalFact


interface ZooAnimalRepository {

    fun getAllAnimalFactsFromDatabase() {}

    suspend fun insertAnimalFact(animal: AnimalFact) {}

    suspend fun deleteAnimalFact(animal:AnimalFact) {}

    suspend fun deleteAllFacts() {}



}