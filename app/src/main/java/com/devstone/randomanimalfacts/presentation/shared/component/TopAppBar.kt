package com.devstone.randomanimalfacts.presentation.shared.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.devstone.randomanimalfacts.presentation.home.GenerateFactScreenEvent
import com.devstone.randomanimalfacts.util.UiEvent


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(title: String,
              actionIcon: ImageVector,
              actionDes: String?,
              onBackPressed: ()-> Unit,
              onNavigate: () -> Unit
) {
    SmallTopAppBar(
        modifier = Modifier,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
                    )
                },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector =  Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        actions = {
            IconButton(onClick = onNavigate ) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionDes
                )
            }
        }
    )
}

