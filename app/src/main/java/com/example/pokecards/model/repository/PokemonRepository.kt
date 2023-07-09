package com.example.pokecards.model.repository

import com.example.pokecards.model.dto.PokemonList
import kotlinx.coroutines.flow.Flow

interface PokemonRepository {
    suspend fun getList(): Flow<PokemonList?>
}