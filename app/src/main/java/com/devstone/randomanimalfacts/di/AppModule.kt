package com.devstone.randomanimalfacts.di

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


/**
 * Dagger Hilt dependency injection. Class contains only singletons.
 * Singletons include: Database, Repository and Retrofit Instance.
 */
@Module
@InstallIn(SingletonComponent::class)
object AppModule {
}