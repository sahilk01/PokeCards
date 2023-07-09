package com.example.pokecards.model.dto

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class StEditionHolofoil(
    val directLow: Any,
    val high: Double,
    val low: Double,
    val market: Double,
    val mid: Double
): Serializable