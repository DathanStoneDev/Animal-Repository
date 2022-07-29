package com.devstone.randomanimalfacts.data.remote

import com.devstone.randomanimalfacts.data.model.AnimalFact
import com.devstone.randomanimalfacts.util.Resource

interface ZooAnimalApiRepository {

    suspend fun getAnimalFactFromRemote() : Resource<AnimalFact>
}