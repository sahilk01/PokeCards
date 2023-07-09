package com.example.pokecards.model.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Ability(
    val name: String?,
    val text: String?,
    val type: String?
): Parcelable