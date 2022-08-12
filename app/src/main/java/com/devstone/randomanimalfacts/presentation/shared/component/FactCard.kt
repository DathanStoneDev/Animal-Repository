package com.devstone.randomanimalfacts.presentation.shared.component

import android.content.res.Resources
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.devstone.randomanimalfacts.data.model.AnimalFact
import com.devstone.randomanimalfacts.presentation.main.ZooAnimalFactEvent
import com.devstone.randomanimalfacts.presentation.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FactCard(
    fact: AnimalFact,
    onEvent: (ZooAnimalFactEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    var favorite by remember {mutableStateOf(false)}

    Card(
        modifier = modifier
            .size(width = 350.dp, height = 600.dp),
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,

        )
    ) {
        AsyncImage(model = fact.image_link, contentDescription = null)
        Spacer(modifier = modifier.padding(top = 15.dp))
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
                    favorite = if (favorite) {
                        onEvent(ZooAnimalFactEvent.FavoriteFact(fact))
                        !favorite
                    } else {
                        onEvent(ZooAnimalFactEvent.RemoveFavoriteFact(fact))
                        !favorite
                    }
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

@Preview
@Composable
fun FactCardPreview() {
    FactCard(
        fact = AnimalFact(
            "Diurnal", "Mammal", "Primarily fruit and leaves, some invertebrates",
            "Malaysia and Sumatra", "Tropical rainforest", 3,
            "https://upload.wikimedia.org/wikipedia/commons/a/a4/DPPP_5348.jpg",
            "Hylobates syndactylus","2.00", "1.90", "23",
            "Siamang", "23", "20"
        ),
        onEvent = {})
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
