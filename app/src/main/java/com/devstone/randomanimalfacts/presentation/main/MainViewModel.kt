package com.devstone.randomanimalfacts.presentation.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devstone.randomanimalfacts.data.local.ZooAnimalRepository
import com.devstone.randomanimalfacts.data.model.AnimalFact
import com.devstone.randomanimalfacts.data.remote.ZooAnimalApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * View model for main landing page.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val local: ZooAnimalRepository,
    private val remote: ZooAnimalApiRepository
) : ViewModel() {

    var fact by mutableStateOf<AnimalFact?>(null)

    fun onEvent(event: ZooAnimalFactEvent) {
        when(event) {
            is ZooAnimalFactEvent.GenerateFact -> {
                viewModelScope.launch(Dispatchers.IO){
                    fact = remote.getAnimalFactFromRemote().data
                }
            }
            is ZooAnimalFactEvent.FavoriteFact -> {
                viewModelScope.launch(Dispatchers.IO) {
                    local.insertAnimalFact(event.fact)
                }
            }
            is ZooAnimalFactEvent.RemoveFavoriteFact -> {
                viewModelScope.launch(Dispatchers.IO) {
                    local.deleteAnimalFact(event.fact)
                }
            }
        }
    }
}