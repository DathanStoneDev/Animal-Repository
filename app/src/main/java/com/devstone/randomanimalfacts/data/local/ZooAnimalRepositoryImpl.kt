package com.devstone.randomanimalfacts.data.local

import javax.inject.Inject

class ZooAnimalRepositoryImpl @Inject constructor(
    private val dao: ZooAnimalDao
) : ZooAnimalRepository {


}