package com.devstone.randomanimalfacts.presentation.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devstone.randomanimalfacts.data.local.ZooAnimalRepository
import com.devstone.randomanimalfacts.data.model.AnimalFact
import com.devstone.randomanimalfacts.data.remote.ZooAnimalApiRepository
import com.devstone.randomanimalfacts.util.UiEvent
import com.devstone.randomanimalfacts.util.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * View model for main landing page.
 */
@HiltViewModel
class GenerateFactViewModel @Inject constructor(
    private val local: ZooAnimalRepository,
    private val remote: ZooAnimalApiRepository
) : ViewModel() {

    var animalFact by mutableStateOf<AnimalFact?>(null)
    var toggleFavorite by mutableStateOf(false)

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    init {
        viewModelScope.launch {
            animalFact = remote.getAnimalFactFromRemote().data
        }
    }


    fun onEvent(event: GenerateFactScreenEvent) {
        when(event) {
            is GenerateFactScreenEvent.GenerateFact -> {
                viewModelScope.launch(Dispatchers.IO){
                    toggleFavorite = false
                    animalFact = remote.getAnimalFactFromRemote().data
                }
            }
            is GenerateFactScreenEvent.ToggleFavoriteClick -> {
                if (toggleFavorite) {
                    toggleFavorite = !toggleFavorite
                    viewModelScope.launch {
                        local.deleteAnimalFact(event.fact)
                    }
                } else {
                    viewModelScope.launch {
                        toggleFavorite = !toggleFavorite
                        local.insertAnimalFact(event.fact)
                    }
                }
            }
            is GenerateFactScreenEvent.GoToSavedFactsClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.SAVED_FACTS_SCREEN))
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }
}