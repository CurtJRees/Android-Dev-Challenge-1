package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun DetailScreen(id: Int) {
    val pet = remember { mutableStateOf(exampleData.first { it.id == id }) }

    DetailScreenContent(pet.value)
}

@Composable
private fun DetailScreenContent(pet: PetItem) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 16.dp)
    ) {

        item {
            Box(contentAlignment = Alignment.BottomEnd) {
                Image(
                    painter = painterResource(pet.image),
                    contentDescription = "Image of ${pet.name}",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                )

                Text(
                    text = pet.price,
                    maxLines = 1,
                    style = MaterialTheme.typography.h4,
                    color = MaterialTheme.colors.primary,
                    modifier = Modifier.padding(8.dp),
                )
            }
        }

        item {
            Text(
                text = pet.name,
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.h4,
                modifier = Modifier.padding(top = 12.dp, bottom = 4.dp)
            )
        }

        item {
            Text(
                text = "${pet.gender} | ${pet.age}",
                maxLines = 1,
                color = MaterialTheme.colors.onSurface,
                style = MaterialTheme.typography.h6,
            )
        }

        item {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = "Location Icon",
                    tint = MaterialTheme.colors.onSurface,
                    modifier = Modifier.alpha(0.8f)
                )
                Text(
                    text = pet.distance,
                    maxLines = 1,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.body1,
                )
            }
        }

        item {
            Text(
                text = pet.description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier.padding(top = 16.dp)
            )
        }


    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun PreviewDetailScreenContent() {
    MyTheme {
        DetailScreenContent(exampleData.first())
    }
}

@Preview(backgroundColor = 0xFF121212, showBackground = true)
@Composable
fun PreviewDetailScreenContentDark() {
    MyTheme(darkTheme = true) {
        DetailScreenContent(exampleData.first())
    }
}
