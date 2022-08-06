package com.devstone.randomanimalfacts.presentation.main

import com.devstone.randomanimalfacts.data.model.AnimalFact

sealed class ZooAnimalFactEvent {
    object GenerateFact: ZooAnimalFactEvent()
    data class SaveFact(val fact: AnimalFact): ZooAnimalFactEvent()
}
