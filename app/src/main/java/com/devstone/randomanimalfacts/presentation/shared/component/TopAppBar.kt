package com.devstone.randomanimalfacts.presentation.shared.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(title: String,
              actionIcon: ImageVector,
              actionDes: String?,
              onBackPressed: ()-> Unit
) {
    SmallTopAppBar(
        modifier = Modifier,
        title = { Text(title) },
        navigationIcon = {
            IconButton(onClick = onBackPressed) {
                Icon(
                    imageVector =  Icons.Filled.ArrowBack,
                    contentDescription = "Back"
                )
            }
        },
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = actionIcon,
                    contentDescription = actionDes
                )
            }
        }
    )
}

