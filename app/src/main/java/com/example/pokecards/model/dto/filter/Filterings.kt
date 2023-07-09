package com.example.pokecards.model.dto.filter


enum class Filterings {
    HP,
    LEVEL;
    companion object {
        val filters get() = mapOf(
            HP to true,
            LEVEL to true,
        )
    }
}