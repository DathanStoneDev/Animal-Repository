package com.devstone.randomanimalfacts.presentation.saved_facts


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devstone.randomanimalfacts.data.local.ZooAnimalRepository
import com.devstone.randomanimalfacts.presentation.main.ZooAnimalFactEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SavedFactsViewModel @Inject constructor(
    private val local: ZooAnimalRepository
) : ViewModel() {


    val savedFacts = local.getAllAnimalFactsFromDatabase()


    fun onEvent(event: SavedAnimalFactEvent) {
        when(event) {
            is SavedAnimalFactEvent.OnDeleteAnimalFact -> {
                viewModelScope.launch(Dispatchers.IO) {
                    local.deleteAnimalFact(event.fact)
                }
            }
            is SavedAnimalFactEvent.OnSelectAnimalFact -> {
                viewModelScope.launch {
                    //send animal fact to selected page
                }
            }
            is SavedAnimalFactEvent.OnDeleteAllAnimalFacts -> {
                viewModelScope.launch(Dispatchers.IO) {
                    local.deleteAllFacts()
                }
            }
        }
    }



}