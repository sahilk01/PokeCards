package com.example.pokecards.view.composables

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.runtime.Composable
import com.example.pokecards.model.dto.Pokemon


@Composable
fun PokemonList(
    pokemonList: List<Pokemon>,
    onClick: ((Pokemon) -> Unit?)? = null
) {
    LazyVerticalGrid(columns = GridCells.Fixed(2), content = {
        items(pokemonList) {
            PokemonCard(pokemon = it, onClick = onClick)
        }
    })
}