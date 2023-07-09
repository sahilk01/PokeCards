package com.example.pokecards.model.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Pokemon(
    val abilities: List<Ability>?,
    val attacks: List<Attack>?,
    val hp: String?,
    val id: String?,
    val images: Images?,
    val level: String?,
    val name: String?,
    val subtypes: List<String>?,
    val types: List<String>?,
    val weaknesses: List<Weaknesse>?,
    val resistances: List<Resistance>?,
): Parcelable