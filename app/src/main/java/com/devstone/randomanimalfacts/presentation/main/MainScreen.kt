package com.devstone.randomanimalfacts.presentation.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.devstone.randomanimalfacts.data.model.AnimalFact
import com.devstone.randomanimalfacts.presentation.shared.component.FactCard
import com.devstone.randomanimalfacts.util.UiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: MainViewModel = hiltViewModel()
) {

    Surface (
        modifier = Modifier.fillMaxSize(),
    ) {
        Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            FactCard(fact = AnimalFact(
                "Diurnal", "Mammal", "Primarily fruit and leaves, some invertebrates",
                "Malaysia and Sumatra", "Tropical rainforest", 3,
                "https://upload.wikimedia.org/wikipedia/commons/a/a4/DPPP_5348.jpg",
                "Hylobates syndactylus","2.00", "1.90", "23",
                "Siamang", "23", "20"
            ) , onEvent = {})
        }

    }


}