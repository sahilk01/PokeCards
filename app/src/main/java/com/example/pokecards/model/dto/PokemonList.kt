package com.example.pokecards.model.dto

import com.google.gson.annotations.SerializedName

data class PokemonList(
    val count: Int,
    @SerializedName("data")
    val pokemonList: List<Pokemon>,
    val page: Int,
    val pageSize: Int,
    val totalCount: Int
)