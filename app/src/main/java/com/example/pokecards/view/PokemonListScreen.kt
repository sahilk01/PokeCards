package com.example.pokecards.view

import android.util.Log
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.showToast
import com.example.pokecards.model.dto.Pokemon
import com.example.pokecards.model.dto.PokemonList
import com.example.pokecards.view.composables.PokemonList
import com.example.pokecards.viewmodel.PokemonListViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@RootNavGraph(start = true)
@Destination
@Composable
fun PokemonListScreen(
    navigator: DestinationsNavigator,
    pokemonListViewModel: PokemonListViewModel = hiltViewModel()
) {
    val pokemonList = pokemonListViewModel.pokemonList.collectAsState()
    val context = LocalContext.current
    pokemonList.value?.onSuccess { pokemons ->
        PokemonList(pokemonList = pokemons)
    }?.onFailure { error ->
        error.message?.let { errorMessage ->
            context.showToast(errorMessage)
        }
    }
}
