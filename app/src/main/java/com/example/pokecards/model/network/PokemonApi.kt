package com.example.pokecards.model.network

import com.example.pokecards.model.dto.PokemonList
import kotlinx.coroutines.flow.Flow
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val DEFAULT_PAGE_SIZE = 20
interface PokemonApi {

    @GET("v2/cards")
    suspend fun getList(
        @Query("pageSize") pageSize: Int = DEFAULT_PAGE_SIZE
    ): Response<PokemonList>

}