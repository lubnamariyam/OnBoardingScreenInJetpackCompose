package com.lubnamariyam.travelapp.model

import androidx.annotation.DrawableRes
import com.lubnamariyam.travelapp.R

data class Page(val title: String , val description : String,
@DrawableRes val image: Int)

val onboardPages = listOf(
    Page(
        "Ready To Travel",
        "Choose the destination, plan your trip , enjoy your holidays",
        R.drawable.home
    ),
    Page(
        "Select The Date",
        "Choose the destination, plan your trip , enjoy your holidays",
        R.drawable.home
    ),
    Page(
        "Feels Like Home",
        "Choose the destination, plan your trip , enjoy your holidays",
        R.drawable.home
    )

)