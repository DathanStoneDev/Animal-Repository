package com.devstone.randomanimalfacts.data.local

import com.devstone.randomanimalfacts.data.model.AnimalFact
import kotlinx.coroutines.flow.Flow


interface ZooAnimalRepository {

    fun getAllAnimalFactsFromDatabase(): Flow<List<AnimalFact>>

    suspend fun insertAnimalFact(animal: AnimalFact)

    suspend fun deleteAnimalFact(animal:AnimalFact)

    suspend fun deleteAllFacts()



}