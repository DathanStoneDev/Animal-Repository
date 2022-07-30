package com.devstone.randomanimalfacts.presentation.main

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

    fun onEvent(event: ZooAnimalEvent) {
        when(event) {
            is ZooAnimalEvent.GenerateFact -> {
                getAnimalFact()
            }
            is ZooAnimalEvent.SaveFact -> {
                saveFact(event.fact)
            }
        }
    }

    private fun getAnimalFact() {
        viewModelScope.launch(Dispatchers.IO) {
            remote.getAnimalFactFromRemote()
        }
    }

    private fun saveFact(fact: AnimalFact) {
        viewModelScope.launch(Dispatchers.IO) {
            local.insertAnimalFact(fact)
        }
    }

}