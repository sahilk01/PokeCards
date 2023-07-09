package com.example.pokecards.model.dto

import java.io.Serializable

data class ReverseHolofoil(
    val directLow: Double,
    val high: Double,
    val low: Double,
    val market: Double,
    val mid: Double
): Serializable