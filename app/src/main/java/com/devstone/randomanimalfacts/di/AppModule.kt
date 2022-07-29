package com.devstone.randomanimalfacts.di

import android.app.Application
import androidx.room.Room
import com.devstone.randomanimalfacts.data.remote.ZooAnimalApi
import com.devstone.randomanimalfacts.data.local.AppDatabase
import com.devstone.randomanimalfacts.data.local.ZooAnimalRepository
import com.devstone.randomanimalfacts.data.local.ZooAnimalRepositoryImpl
import com.devstone.randomanimalfacts.data.remote.ZooAnimalApiRepository
import com.devstone.randomanimalfacts.data.repository.ZooAnimalApiRepositoryImpl
import com.devstone.randomanimalfacts.util.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


/**
 * Dagger Hilt dependency injection. Class contains only singletons.
 * Singletons include: Database, Repository and Retrofit Instance.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesRetrofitApi(): ZooAnimalApi {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ZooAnimalApi::class.java)
    }

    @Provides
    @Singleton
    fun providesZooAnimalDatabase(app: Application): AppDatabase {
        return Room.databaseBuilder(
            app,
            AppDatabase::class.java,
            Constants.DATABASE_NAME
        )
            .build()
    }

    @Provides
    @Singleton
    fun providesZooAnimalApiRepository(api: ZooAnimalApi) : ZooAnimalApiRepository {
        return ZooAnimalApiRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun providesZooAnimalARepository(db: AppDatabase) : ZooAnimalRepository {
        return ZooAnimalRepositoryImpl(db.zooAnimalDao())
    }
}
