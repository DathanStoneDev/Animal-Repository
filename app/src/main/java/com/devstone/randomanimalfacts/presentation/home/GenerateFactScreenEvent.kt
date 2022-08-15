package com.devstone.randomanimalfacts.presentation.home

import com.devstone.randomanimalfacts.data.model.AnimalFact

sealed class GenerateFactScreenEvent {
    object GenerateFact: GenerateFactScreenEvent()
    object GoToSavedFactsClick : GenerateFactScreenEvent()
    data class FavoriteFact(val fact: AnimalFact): GenerateFactScreenEvent()
    data class RemoveFavoriteFact(val fact: AnimalFact) : GenerateFactScreenEvent()
}
