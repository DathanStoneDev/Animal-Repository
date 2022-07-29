package com.devstone.randomanimalfacts.repositories

import com.devstone.randomanimalfacts.data.local.ZooAnimalRepository

class FakeZooAnimalRepository : ZooAnimalRepository {

    /*private var shouldReturnError = false

    override suspend fun getAnimalFromApi(): Resource<Animal> {
        return if (shouldReturnError) {
            Resource.Error("Error", null)
        } else {
            Resource.Success(
                Animal(
                "Diurnal", "Mammal", "Primarily fruit and leaves, some invertebrates",
                "Malaysia and Sumatra", "Tropical rainforest", 162,
                "https://upload.wikimedia.org/wikipedia/commons/a/a4/DPPP_5348.jpg",
                "Hylobates syndactylus","2.00", "1.90", "23",
                "Siamang", "23", "20")
            )
        }
    }

    override fun getAllAnimals(): Flow<List<Animal>> {
        TODO("Not yet implemented")
    }

    override suspend fun insertAnimal(animal: Animal) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAnimal(animal: Animal) {
        TODO("Not yet implemented")
    }

    fun setShouldReturnError(value: Boolean) {
        shouldReturnError = value
    } */


}