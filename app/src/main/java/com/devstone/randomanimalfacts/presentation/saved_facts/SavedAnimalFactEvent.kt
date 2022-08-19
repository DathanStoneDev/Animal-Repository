package com.devstone.randomanimalfacts.presentation.saved_facts

import com.devstone.randomanimalfacts.data.model.AnimalFact

sealed class SavedAnimalFactEvent {
    data class OnDeleteAnimalFact(val fact: AnimalFact) : SavedAnimalFactEvent()
    data class OnSelectAnimalFact(val id: Int) : SavedAnimalFactEvent()
    object OnDeleteAllAnimalFacts : SavedAnimalFactEvent()
    data class ToggleFavoriteClick(val fact: AnimalFact) : SavedAnimalFactEvent()

}
