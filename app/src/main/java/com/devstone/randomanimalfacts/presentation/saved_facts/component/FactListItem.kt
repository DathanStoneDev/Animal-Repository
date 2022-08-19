package com.devstone.randomanimalfacts.presentation.saved_facts.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.devstone.randomanimalfacts.presentation.saved_facts.SavedAnimalFactEvent

@Composable
fun FactListItem(
    animalName: String,
    imgLink: String,
    id: Int,
    onFactClick: (SavedAnimalFactEvent.OnSelectAnimalFact) -> Unit
) {
    Row (
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.clickable {
            onFactClick(SavedAnimalFactEvent.OnSelectAnimalFact(id))
        }

    ){
        AsyncImage(
            model = imgLink,
            contentScale = ContentScale.Crop,
            contentDescription = null,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .size(80.dp)
                .weight(1f)
                .padding(end = 20.dp)
        )
        Text(text = animalName, Modifier.weight(2f))
    }
    Divider(
        thickness = 1.dp,
        startIndent = 100.dp,
        modifier = Modifier.padding(vertical = 5.dp),
        color = MaterialTheme.colorScheme.tertiary
    )
}

@Preview
@Composable
fun FactListItemPreview() {
    FactListItem(
        animalName = "Siamang",
        imgLink = "https://upload.wikimedia.org/wikipedia/commons/a/a4/DPPP_5348.jpg",
        id = 2,
        onFactClick = {}
    )
}