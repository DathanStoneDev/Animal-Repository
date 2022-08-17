package com.devstone.randomanimalfacts.presentation.home

import com.devstone.randomanimalfacts.data.model.AnimalFact

sealed class GenerateFactScreenEvent {
    object GenerateFact: GenerateFactScreenEvent()
    object GoToSavedFactsClick : GenerateFactScreenEvent()
    data class ToggleFavoriteClick(val fact: AnimalFact) : GenerateFactScreenEvent()
}
