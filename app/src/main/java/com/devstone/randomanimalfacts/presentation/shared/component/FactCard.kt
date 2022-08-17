package com.devstone.randomanimalfacts.presentation.shared.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.SubcomposeAsyncImage
import com.devstone.randomanimalfacts.data.model.AnimalFact
import com.devstone.randomanimalfacts.presentation.home.GenerateFactScreenEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactCard(
    fact: AnimalFact,
    modifier: Modifier = Modifier,
    onEvent: (GenerateFactScreenEvent) -> Unit,
    favorite: Boolean,
) {

    Card(
        modifier = modifier
            .size(width = 350.dp, height = 600.dp),
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,

        )
    ) {
        Spacer(modifier = modifier.padding(top = 5.dp))
        Box(modifier = modifier
            .fillMaxWidth()
            .height(250.dp),
            contentAlignment = Alignment.Center
        ) {
            SubcomposeAsyncImage(
                model = fact.image_link,
                contentScale = ContentScale.Inside,
                contentDescription = null,
                loading = {
                    CircularProgressIndicator()
                },
                modifier = modifier.clip(RoundedCornerShape(5.dp))
            )
        }
        Spacer(modifier = modifier.padding(top = 10.dp))
        FactCardText(data = fact.name, label = "Name: " )
        FactCardText(data = fact.latin_name, label = "Latin Name: ")
        FactCardText(data = fact.animal_type, label = "Animal Type: ")
        FactCardText(data = fact.geo_range, label = "Location: ")
        FactCardText(data = fact.habitat, label = "Habitat: ")
        FactCardText(data = fact.active_time, label = "Active Time: " )
        FactCardText(data = fact.diet, label = "Diet: ")
        FactCardText(data = fact.weight_min + " - " + fact.weight_max + " pounds", label = "Weight: ")
        FactCardText(data = fact.length_min + " - " + fact.length_max + " feet", label = "Length: ")
        Spacer(modifier = modifier.weight(1f))
        Row (){
            IconButton(
                onClick = {
                    onEvent(GenerateFactScreenEvent.ToggleFavoriteClick(fact))
                },
                modifier = modifier.weight(1f)
            ) {
                if (favorite) {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = "favorite",
                        tint = Color.Red
                    )
                } else {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = "not favorite",
                        tint = MaterialTheme.colorScheme.background
                    )
                }
            }
        }
    }
}



@Composable
fun FactCardText(label: String, data: String) {
    Row(modifier = Modifier.padding(start = 5.dp, top = 3.dp)) {
        Text(
            text = label,
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.labelSmall

        )
        Text(
            text = data,
            color = MaterialTheme.colorScheme.tertiary,
            style = MaterialTheme.typography.bodyLarge

        )
    }
}
