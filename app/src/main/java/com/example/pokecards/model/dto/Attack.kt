package com.example.pokecards.model.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Attack(
    val convertedEnergyCost: Int?,
    val cost: List<String>?,
    val damage: String?,
    val name: String?,
    val text: String?
): Parcelable