package com.devstone.randomanimalfacts.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.devstone.randomanimalfacts.data.model.AnimalFact

@Database(entities = [AnimalFact::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun zooAnimalDao(): ZooAnimalDao

    companion object {
        const val DATABASE_NAME = "zoo_animals_db"
    }
}