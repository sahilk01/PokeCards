package com.example.pokecards.model.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Legalities(
    val expanded: String?,
    val unlimited: String?
): Parcelable