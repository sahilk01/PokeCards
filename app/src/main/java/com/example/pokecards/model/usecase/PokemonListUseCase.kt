package com.example.pokecards.model.usecase

import com.example.pokecards.model.dto.PokemonList
import kotlinx.coroutines.flow.Flow

interface PokemonListUseCase: SuspendingUseCase<Flow<PokemonList?>>