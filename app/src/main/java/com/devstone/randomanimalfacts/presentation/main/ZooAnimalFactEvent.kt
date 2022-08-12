package com.devstone.randomanimalfacts.presentation.main

import com.devstone.randomanimalfacts.data.model.AnimalFact

sealed class ZooAnimalFactEvent {
    object GenerateFact: ZooAnimalFactEvent()
    data class FavoriteFact(val fact: AnimalFact): ZooAnimalFactEvent()
    data class RemoveFavoriteFact(val fact: AnimalFact) : ZooAnimalFactEvent()
}
