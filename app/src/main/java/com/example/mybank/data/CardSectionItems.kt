package com.example.mybank.data

import androidx.compose.ui.graphics.Brush

data class CardSectionItems(
    val cardType : String,
    val cardNumber : String,
    val cardName : String,
    val cardBalance : Double,
    val color : Brush
)
