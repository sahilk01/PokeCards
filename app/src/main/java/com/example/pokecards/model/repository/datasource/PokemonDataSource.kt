package com.example.pokecards.model.repository.datasource

import com.example.pokecards.model.dto.PokemonList
import kotlinx.coroutines.flow.Flow

interface PokemonDataSource {
    suspend fun getList(): Flow<PokemonList?>
}