/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
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
fun HomeScreen(onItemClicked: (PetItem) -> Unit) {

    val state = remember { mutableStateOf(exampleData) }

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 16.dp, horizontal = 0.dp)
    ) {
        items(state.value) {
            ListItem(
                pet = it,
                modifier = Modifier.padding(horizontal = 16.dp),
                onClick = { onItemClicked.invoke(it) }
            )
        }
    }
}

@Composable
fun ListItem(pet: PetItem, modifier: Modifier = Modifier, onClick: () -> Unit = {}) {

    val cornerShape = RoundedCornerShape(12.dp)

    Card(
        shape = cornerShape,
        modifier = modifier.fillMaxWidth()
    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .clickable(onClick = onClick)
                .padding(8.dp)
        ) {
            Image(
                painter = painterResource(pet.image),
                contentDescription = "Image of ${pet.name}",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .requiredSize(64.dp)
                    .clip(cornerShape)
            )

            Spacer(Modifier.width(16.dp))

            Column(Modifier.weight(1f)) {
                Text(
                    text = pet.name,
                    style = MaterialTheme.typography.h5,
                    color = MaterialTheme.colors.onSurface,
                    maxLines = 1,
                )

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

                Text(
                    text = "${pet.gender} | ${pet.age}",
                    maxLines = 1,
                    color = MaterialTheme.colors.onSurface,
                    style = MaterialTheme.typography.body2,
                )
            }

            Spacer(Modifier.width(16.dp))

            Text(
                text = pet.price,
                maxLines = 1,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.primary,
                modifier = Modifier,
            )
        }
    }
}

@Preview(backgroundColor = 0xFFFFFFFF, showBackground = true)
@Composable
fun PreviewListItem() {
    MyTheme {
        Column(Modifier.fillMaxWidth()) {
            ListItem(pet = exampleData.random(), modifier = Modifier.padding(16.dp))
        }
    }
}

@Preview(backgroundColor = 0xFF121212, showBackground = true)
@Composable
fun PreviewListItemDark() {
    MyTheme(darkTheme = true) {
        Column(Modifier.fillMaxWidth()) {
            ListItem(pet = exampleData.random(), modifier = Modifier.padding(16.dp))
        }
    }
}
