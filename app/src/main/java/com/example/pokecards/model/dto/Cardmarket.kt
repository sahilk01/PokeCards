package com.example.pokecards.model.dto

import java.io.Serializable

data class Cardmarket(
    val prices: Prices,
    val updatedAt: String,
    val url: String
): Serializable