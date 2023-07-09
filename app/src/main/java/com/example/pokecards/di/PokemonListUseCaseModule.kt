package com.example.pokecards.di

import com.example.pokecards.model.repository.PokemonRepository
import com.example.pokecards.model.repository.PokemonRepositoryImpl
import com.example.pokecards.model.usecase.PokemonListUseCase
import com.example.pokecards.model.usecase.PokemonListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.migration.DisableInstallInCheck

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonListUseCaseModule {
    @Binds
    abstract fun providePokeListUseCase(
        pokemonListUseCaseImpl: PokemonListUseCaseImpl
    ): PokemonListUseCase
}