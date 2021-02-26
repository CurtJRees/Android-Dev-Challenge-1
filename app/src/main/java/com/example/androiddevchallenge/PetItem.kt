package com.example.androiddevchallenge

import androidx.annotation.DrawableRes

data class PetItem(
    val id: Int,
    val name: String,
    val breed: String,
    val gender: String,
    val description: String,
    val distance: String,
    val age: String,
    val price: String,
    @DrawableRes val image: Int
)


val exampleData = listOf(
    PetItem(
        id = 0,
        name = "Maddie",
        breed = "Dalmatian",
        gender = "Female",
        description = "This is Maddie, she's a super playful and energetic dog. She loves walks and jumping in puddles",
        distance = "2.0 miles",
        age = "8 months",
        price = "$35",
        image = R.drawable.maddie
    ),
    PetItem(
        id = 1,
        name = "Tony",
        breed = "Bulldog",
        gender = "Male",
        description = "Desc",
        distance = "3.4 miles",
        age = "4 months",
        price = "$60",
        image = R.drawable.tony
    ),
    PetItem(
        id = 2,
        name = "Luke",
        breed = "Labrador",
        gender = "Male",
        description = "Desc",
        distance = "6.1 miles",
        age = "9 months",
        price = "$45",
        image = R.drawable.luke
    ),
    PetItem(
        id = 3,
        name = "Figgy",
        breed = "French Bulldog",
        gender = "Female",
        description = "Desc",
        distance = "6.8 miles",
        age = "4 months",
        price = "$100",
        image = R.drawable.figgy
    ),
    PetItem(
        id = 4,
        name = "Skip",
        breed = "Pug",
        gender = "Male",
        description = "Desc",
        distance = "6.5 miles",
        age = "5 months",
        price = "$90",
        image = R.drawable.skip
    )
)