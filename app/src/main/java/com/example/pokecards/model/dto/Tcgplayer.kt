package com.example.pokecards.model.dto

import java.io.Serializable

data class Tcgplayer(
    val prices: PricesX,
    val updatedAt: String,
    val url: String
): Serializable