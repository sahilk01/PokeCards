package com.example.pokecards.model.repository

import com.example.pokecards.model.dto.PokemonList
import com.example.pokecards.model.network.PokemonApi
import com.example.pokecards.model.repository.datasource.PokemonDataSource
import com.example.pokecards.model.repository.datasource.PokemonNetworkDataSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonRepositoryImpl @Inject constructor(
    private val pokemonNetworkDataSource: PokemonDataSource
): PokemonRepository {

    override suspend fun getList(): Flow<PokemonList?> = pokemonNetworkDataSource.getList()
}