package com.devstone.randomanimalfacts

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.devstone.randomanimalfacts.data.local.AppDatabase
import com.devstone.randomanimalfacts.data.model.AnimalFact
import kotlinx.coroutines.runBlocking
import org.junit.After

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Before

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ZooAnimalDaoTest {

    private lateinit var db: AppDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java).build()
    }

    @After
    fun closeDb() {
        db.close()
    }



    @Test
    fun insertAnimalFact() = runBlocking {
        val animalFact = AnimalFact(
            "Diurnal", "Mammal", "Primarily fruit and leaves, some invertebrates",
            "Malaysia and Sumatra", "Tropical rainforest", 162,
            "https://upload.wikimedia.org/wikipedia/commons/a/a4/DPPP_5348.jpg",
            "Hylobates syndactylus","2.00", "1.90", "23",
            "Siamang", "23", "20"
        )

        db.zooAnimalDao().insertAnimalFact(animalFact)

        //Make 2 more animal facts
        //Test for size of list
    }
}