package com.devstone.randomanimalfacts.presentation.shared.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.devstone.randomanimalfacts.data.model.AnimalFact
import com.devstone.randomanimalfacts.presentation.main.ZooAnimalFactEvent

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
        colors = CardDefaults.cardColors()
    ) {
        AsyncImage(model = fact.image_link, contentDescription = null)
        Spacer(modifier = modifier.padding(top = 15.dp))
        FactCardText(data = "Name: " + fact.name)
        FactCardText(data = "Latin Name: " + fact.latin_name)
        FactCardText(data = "Animal Type: " + fact.animal_type)
        FactCardText(data = "Location: " + fact.geo_range)
        FactCardText(data = "Habitat: " + fact.habitat)
        FactCardText(data = "Active Time: " + fact.active_time)
        FactCardText(data = "Diet: " + fact.diet)
        FactCardText(data = "Weight: " + fact.weight_min + " - " + fact.weight_max + " pounds")
        FactCardText(data = "Length: " + fact.length_min + " - " + fact.length_max + " feet")
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
                        contentDescription = "save",
                        tint = Color.Red
                    )
                } else {
                    Icon(
                        imageVector = Icons.Outlined.Favorite,
                        contentDescription = "save",
                        tint = Color.Black
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
fun FactCardText(data: String) {
    Text(
        text = data,
        modifier = Modifier.padding(start = 5.dp, top = 3.dp),
    )
}