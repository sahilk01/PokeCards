package com.example.pokecards.model.network

import com.example.pokecards.model.dto.PokemonList
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET

interface PokemonApi {

    @GET("v2/cards?pageSize=20&page=1")
    suspend fun getList(): Response<PokemonList>

}