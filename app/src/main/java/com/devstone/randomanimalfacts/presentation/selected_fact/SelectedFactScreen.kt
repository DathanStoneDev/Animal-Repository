package com.devstone.randomanimalfacts.presentation.selected_fact

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.devstone.randomanimalfacts.presentation.shared.component.FactCard


@Composable
fun SelectedFactScreen(
    onPopBackStack: () -> Unit,
    viewModel: SelectedFactScreenViewModel = hiltViewModel()
) {



    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center) {

            if (viewModel.animalFact != null) {
                FactCard(
                    fact = viewModel.animalFact!!,
                    onEvent = null,
                    favorite = true
                )
            }
        }
    }
}
