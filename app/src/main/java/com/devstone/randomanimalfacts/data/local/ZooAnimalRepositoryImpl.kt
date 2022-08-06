package com.devstone.randomanimalfacts.data.local

import com.devstone.randomanimalfacts.data.model.AnimalFact
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ZooAnimalRepositoryImpl @Inject constructor(
    private val dao: ZooAnimalDao
) : ZooAnimalRepository {

    override fun getAllAnimalFactsFromDatabase(): Flow<List<AnimalFact>> {
        return dao.getAllAnimalFacts()
    }

    override suspend fun getAnimalFactById(id: Int): AnimalFact? {
        return dao.getAnimalFactById(id)
    }

    override suspend fun insertAnimalFact(animal: AnimalFact) {
        return dao.insertAnimalFact(animal)
    }

    override suspend fun deleteAnimalFact(fact: AnimalFact) {
        return dao.deleteAnimalFact(fact)
    }

    override suspend fun deleteAllFacts() {
        return dao.deleteAllFacts()
    }
}