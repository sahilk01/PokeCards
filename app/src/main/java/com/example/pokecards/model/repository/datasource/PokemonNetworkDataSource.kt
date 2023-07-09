package com.example.pokecards.model.repository.datasource

import com.example.pokecards.model.dto.PokemonList
import com.example.pokecards.model.network.PokemonApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PokemonNetworkDataSource @Inject constructor(
    private val pokemonApi: PokemonApi
): PokemonDataSource {
    override suspend fun getList(): Flow<PokemonList?> = flow {
        emit(pokemonApi.getList().body())
//        emit(null)
    }
}