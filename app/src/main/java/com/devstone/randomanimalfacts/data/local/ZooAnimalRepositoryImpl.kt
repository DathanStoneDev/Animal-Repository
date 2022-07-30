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
}