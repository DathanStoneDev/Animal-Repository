package com.devstone.randomanimalfacts.data.local

import androidx.room.*
import com.devstone.randomanimalfacts.data.model.AnimalFact
import kotlinx.coroutines.flow.Flow

@Dao
interface ZooAnimalDao {

    @Query("SELECT * FROM animals")
    fun getAllAnimalFacts(): Flow<List<AnimalFact>>

    @Query("SELECT * FROM animals WHERE :id=id")
    suspend fun getAnimalFactById(id: Int): AnimalFact

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnimalFact(animal: AnimalFact)

    @Delete
    suspend fun deleteAnimalFact(animal:AnimalFact)

    @Query("DELETE FROM animals")
    suspend fun deleteAllFacts()
}