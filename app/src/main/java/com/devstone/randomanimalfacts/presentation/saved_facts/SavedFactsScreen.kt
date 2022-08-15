package com.devstone.randomanimalfacts.presentation.saved_facts

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.devstone.randomanimalfacts.presentation.saved_facts.component.FactListItem
import com.devstone.randomanimalfacts.util.UiEvent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedFactsScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    onPopBackStack : () -> Unit,
    viewModel: SavedFactsViewModel = hiltViewModel()
) {

    val savedFacts = viewModel.savedFacts.collectAsState(initial = emptyList());
    
    Surface (
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 100.dp)
        ) {
            items(savedFacts.value) { fact ->
                FactListItem(
                    animalName = fact.name,
                    imgLink = fact.image_link,
                )
            }
        }
    }
}