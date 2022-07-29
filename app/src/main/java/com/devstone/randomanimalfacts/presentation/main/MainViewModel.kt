package com.devstone.randomanimalfacts.presentation.main

import androidx.lifecycle.ViewModel
import com.devstone.randomanimalfacts.data.local.ZooAnimalRepository
import com.devstone.randomanimalfacts.data.remote.ZooAnimalApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * View model for main landing page.
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val local: ZooAnimalRepository,
    private val remote: ZooAnimalApiRepository
) : ViewModel() {

}