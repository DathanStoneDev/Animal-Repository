package com.devstone.randomanimalfacts.presentation.selected_fact

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devstone.randomanimalfacts.data.local.ZooAnimalRepository
import com.devstone.randomanimalfacts.data.model.AnimalFact
import com.devstone.randomanimalfacts.presentation.saved_facts.SavedAnimalFactEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SelectedFactScreenViewModel @Inject constructor(
    private val local: ZooAnimalRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {


    var animalFact by mutableStateOf<AnimalFact?>(null)


    init {
        val factId = savedStateHandle.get<Int>("id")!!
        viewModelScope.launch (Dispatchers.IO) {
            local.getAnimalFactById(factId).let { fact ->
                animalFact = fact
            }
        }
    }

    fun onEvent(event: SavedAnimalFactEvent) {
        when (event) {


        }
    }
}