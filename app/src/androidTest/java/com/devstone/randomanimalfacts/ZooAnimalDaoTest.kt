package com.devstone.randomanimalfacts

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.devstone.randomanimalfacts.data.local.AppDatabase
import com.devstone.randomanimalfacts.data.local.ZooAnimalDao
import com.devstone.randomanimalfacts.data.model.AnimalFact
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Test
import org.hamcrest.Matchers.equalTo
import org.junit.runner.RunWith
import org.junit.Assert.*
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class ZooAnimalDaoTest {

    private lateinit var db: AppDatabase
    private lateinit var zooAnimalDao: ZooAnimalDao

    private val animalFact1 = AnimalFact(
        "Diurnal", "Mammal", "Primarily fruit and leaves, some invertebrates",
        "Malaysia and Sumatra", "Tropical rainforest", 1,
        "https://upload.wikimedia.org/wikipedia/commons/a/a4/DPPP_5348.jpg",
        "Hylobates syndactylus","2.00", "1.90", "23",
        "Siamang", "23", "20"
    )

    private val animalFact2 = AnimalFact(
        "Diurnal", "Mammal", "Primarily fruit and leaves, some invertebrates",
        "Malaysia and Sumatra", "Tropical rainforest", 2,
        "https://upload.wikimedia.org/wikipedia/commons/a/a4/DPPP_5348.jpg",
        "Hylobates syndactylus","2.00", "1.90", "23",
        "Siamang", "23", "20"
    )

    private val animalFact3 = AnimalFact(
        "Diurnal", "Mammal", "Primarily fruit and leaves, some invertebrates",
        "Malaysia and Sumatra", "Tropical rainforest", 3,
        "https://upload.wikimedia.org/wikipedia/commons/a/a4/DPPP_5348.jpg",
        "Hylobates syndactylus","2.00", "1.90", "23",
        "Siamang", "23", "20"
    )

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDatabase::class.java)
            .build()
        zooAnimalDao = db.zooAnimalDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun `should insert an animal fact `() = runBlocking {

        //inserts fact
        zooAnimalDao.insertAnimalFact(animalFact1)

        val check = zooAnimalDao.getAnimalFactById(1)

        //checks insertion
        assertThat(check.id, equalTo(1))
    }

    @Test
    fun `should delete an animal fact checking single deletion` () = runBlocking {

        //inserts fact
        zooAnimalDao.insertAnimalFact(animalFact1)

        //check to ensure fact was inserted
        assertThat(zooAnimalDao.getAnimalFactById(1), equalTo(animalFact1))

        //delete fact
        zooAnimalDao.deleteAnimalFact(animalFact1)

        val check = zooAnimalDao.getAnimalFactById(1)

        //checks single deletion
        assertThat(check, equalTo(null))
    }

    @Test
    fun `should delete all facts that have been inserted` () = runBlocking{

        //inserts fact
        zooAnimalDao.insertAnimalFact(animalFact1)
        zooAnimalDao.insertAnimalFact(animalFact2)
        zooAnimalDao.insertAnimalFact(animalFact3)

        //checks for all facts being inserted
        assertThat(zooAnimalDao.getAnimalFactById(1), equalTo(animalFact1))
        assertThat(zooAnimalDao.getAnimalFactById(2), equalTo(animalFact2))
        assertThat(zooAnimalDao.getAnimalFactById(3), equalTo(animalFact3))

        //deletes all facts
        zooAnimalDao.deleteAllFacts()

        val check1 = zooAnimalDao.getAnimalFactById(1)
        val check2 = zooAnimalDao.getAnimalFactById(2)
        val check3 = zooAnimalDao.getAnimalFactById(3)

        //checks for all facts being deleted.
        assertThat(check1, equalTo(null))
        assertThat(check2, equalTo(null))
        assertThat(check3, equalTo(null))
    }


}