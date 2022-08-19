package com.devstone.randomanimalfacts.presentation.saved_facts


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devstone.randomanimalfacts.data.local.ZooAnimalRepository
import com.devstone.randomanimalfacts.util.UiEvent
import com.devstone.randomanimalfacts.util.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedFactsViewModel @Inject constructor(
    private val local: ZooAnimalRepository
) : ViewModel() {

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()
    val savedFacts = local.getAllAnimalFactsFromDatabase()

    init {

    }


    fun onEvent(event: SavedAnimalFactEvent) {
        when(event) {
            is SavedAnimalFactEvent.OnDeleteAnimalFact -> {
                viewModelScope.launch(Dispatchers.IO) {
                    local.deleteAnimalFact(event.fact)
                }
            }
            is SavedAnimalFactEvent.OnSelectAnimalFact -> {
                viewModelScope.launch (Dispatchers.IO){
                    sendUiEvent(UiEvent.Navigate(Routes.SELECTED_FACT_SCREEN + "?id=${event.id}"))
                }
            }
            is SavedAnimalFactEvent.OnDeleteAllAnimalFacts -> {
                viewModelScope.launch(Dispatchers.IO) {
                    local.deleteAllFacts()
                }
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

}