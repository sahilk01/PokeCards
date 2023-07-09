package com.example.pokecards.model.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable

@Parcelize
data class Images(
    val large: String?,
    val small: String?
): Parcelable