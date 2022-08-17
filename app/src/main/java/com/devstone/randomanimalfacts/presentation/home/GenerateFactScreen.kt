package com.devstone.randomanimalfacts.presentation.home

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.devstone.randomanimalfacts.presentation.shared.component.FactCard
import com.devstone.randomanimalfacts.presentation.shared.component.TopAppBar
import com.devstone.randomanimalfacts.util.UiEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: GenerateFactViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event) {
                is UiEvent.Navigate -> onNavigate(event)
            }
        }
    }

    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {
            TopAppBar(
                title = "Random Animal Facts",
                actionIcon = Icons.Default.List,
                actionDes = "Saved Facts",
                onNavigate = { viewModel.onEvent(GenerateFactScreenEvent.GoToSavedFactsClick) },
                onBackPressed = {}
            )
            if (viewModel.animalFact != null) {
                FactCard(
                    fact = viewModel.animalFact!!,
                    onEvent = viewModel::onEvent,
                    favorite = viewModel.toggleFavorite
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = { viewModel.onEvent(GenerateFactScreenEvent.GenerateFact) }){
                Text(text = "Generate New Fact")
            }
        }


    }


}