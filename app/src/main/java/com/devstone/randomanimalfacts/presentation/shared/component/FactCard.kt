package com.devstone.randomanimalfacts.presentation.shared.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
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

    Card(
        modifier = modifier
            .size(width = 300.dp, height = 400.dp),
        shape = CardDefaults.elevatedShape,
        colors = CardDefaults.cardColors()
    ) {
        Box(
            modifier = modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            Column() {
                AsyncImage(model = fact.image_link, contentDescription = null)
               Row {
                   IconButton(onClick = {
                       onEvent(ZooAnimalFactEvent.SaveFact(fact))
                   }) {
                       Icon(imageVector = Icons.Outlined.Favorite, contentDescription = "save")
                   }
               }
                Text(text = fact.name)
                Text(text = fact.latin_name)
                Text(text = fact.animal_type)
                Text(text = fact.diet)
                Text(text = fact.weight_min)
                Text(text = fact.weight_max)
                Text(text = fact.geo_range)
                Text(text = fact.active_time)
                Text(text = fact.habitat)
                Text(text = fact.length_min)
                Text(text = fact.length_max)
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