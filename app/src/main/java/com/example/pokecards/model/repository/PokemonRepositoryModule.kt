package com.example.pokecards.model.repository

import com.example.pokecards.model.network.PokemonApi
import com.example.pokecards.model.repository.datasource.PokemonDataSource
import com.example.pokecards.model.repository.datasource.PokemonNetworkDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.migration.DisableInstallInCheck

@Module
@InstallIn(ViewModelComponent::class)
abstract class PokemonRepositoryModule {

    @Binds
    abstract fun bindPokemonRepository(
        pokemonRepositoryImpl: PokemonRepositoryImpl
    ): PokemonRepository

    @Binds
    abstract fun bindPokemonDataSource(
        pokemonNetworkDataSource: PokemonNetworkDataSource
    ): PokemonDataSource

}

//@Module
//@InstallIn(ViewModelComponent::class)
//object PokemonRepositoryModule {
//
//    @Provides
//    fun providePokemonRepository(
//        pokemonDataSource: PokemonDataSource
//    ): PokemonRepository {
//        return PokemonRepositoryImpl(pokemonDataSource)
//    }
//
//    @Provides
//    fun providePokemonDataSource(
////        pokemonApi: PokemonApi
//    ): PokemonDataSource {
//        return PokemonNetworkDataSource()
//    }
//
//}