package com.example.pokecards.model.usecase

import com.example.pokecards.model.dto.PokemonList
import com.example.pokecards.model.repository.PokemonRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PokemonListUseCaseImpl @Inject constructor(
    private val pokemonRepository: PokemonRepository
): PokemonListUseCase {
    override suspend fun execute(): Flow<PokemonList?> {
        return withContext(Dispatchers.IO) {
            pokemonRepository.getList()
        }
    }
}