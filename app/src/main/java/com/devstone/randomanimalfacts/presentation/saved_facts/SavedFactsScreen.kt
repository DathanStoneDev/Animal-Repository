package com.devstone.randomanimalfacts.presentation.saved_facts

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import com.devstone.randomanimalfacts.presentation.saved_facts.component.FactListItem
import com.devstone.randomanimalfacts.presentation.shared.component.TopAppBar
import com.devstone.randomanimalfacts.util.UiEvent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SavedFactsScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    onPopBackStack : () -> Unit,
    viewModel: SavedFactsViewModel = hiltViewModel()
) {

    val savedFacts = viewModel.savedFacts.collectAsState(initial = emptyList())

    Scaffold(
        topBar = {
            TopAppBar(
                title = "My Facts",
                actionIcon = Icons.Filled.Menu,
                actionDes = "Facts menu",
                onBackPressed = { }
            )
        },
    ) {
        LazyColumn {
            items(savedFacts.value, key = {fact -> fact.id}) {
                FactListItem(

                )
            }
        }
    }
}