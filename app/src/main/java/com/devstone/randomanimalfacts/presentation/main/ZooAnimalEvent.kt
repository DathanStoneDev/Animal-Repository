package com.devstone.randomanimalfacts.presentation.main

import com.devstone.randomanimalfacts.data.model.AnimalFact

sealed class ZooAnimalEvent {
    object GenerateFact: ZooAnimalEvent()
    data class SaveFact(val fact: AnimalFact): ZooAnimalEvent()
}
