package com.devstone.randomanimalfacts.data.repository

import com.devstone.randomanimalfacts.data.remote.ZooAnimalApi
import com.devstone.randomanimalfacts.data.model.AnimalFact
import com.devstone.randomanimalfacts.data.remote.ZooAnimalApiRepository
import com.devstone.randomanimalfacts.util.Resource
import retrofit2.HttpException
import javax.inject.Inject

class ZooAnimalApiRepositoryImpl @Inject constructor(
    private val zooAnimalApi: ZooAnimalApi,
) : ZooAnimalApiRepository {

    override suspend fun getAnimalFactFromRemote(): Resource<AnimalFact> {
        return try {
            val response = zooAnimalApi.getAnimalFact()
            if (response.isSuccessful) {
                response.body()?.let {
                    return@let Resource.Success(it)
                } ?: Resource.Error("Oh No, an unknown error occurred", null)
            } else {
                Resource.Error("Oh No, an unknown error occurred", null)
            }
        } catch (e: HttpException) {
            e.printStackTrace()
            Resource.Error("Could not load the data", null)
        }
    }
}

