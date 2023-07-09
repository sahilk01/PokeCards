
package com.example.pokecards.view.pokemonlist

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.showToast
import com.example.pokecards.ui.theme.LightGray
import com.example.pokecards.view.composables.FilterOptions
import com.example.pokecards.view.composables.Loader
import com.example.pokecards.view.composables.PokemonList
import com.example.pokecards.view.composables.SearchField
import com.example.pokecards.view.composables.SortingOptions
import com.example.pokecards.view.destinations.PokemonDetailScreenDestination
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
    val loading = pokemonListViewModel.loading.collectAsState()
    val pokemonList = pokemonListViewModel.pokemonList.collectAsState()
    val sorting = pokemonListViewModel.sorting.collectAsState()
    val sortedBy = pokemonListViewModel.sortedBy.collectAsState()
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .background(color = LightGray)
    ) {

        if (loading.value) {
            Loader()
        }

        pokemonList.value?.onSuccess { pokemons ->
            SearchField(onBackPress = {}, onSearch = { searchQuery ->
                pokemonListViewModel.search(searchQuery)
            })
            Box {
                LazyRow(content = {
                    SortingOptions(
                        selectedSorting = sorting.value,
                        onSortSelected = { selectedSorting ->
                            pokemonListViewModel.sort(selectedSorting)
                        })
                    FilterOptions(filters = sortedBy.value, onFilterSelected = { selectedFilter ->
                        pokemonListViewModel.sortedBy(selectedFilter.first, selectedFilter.second)
                    })
                })
            }
            PokemonList(
                pokemonList = pokemons,
                onClick = { pokemon ->
                    navigator.navigate(
                        PokemonDetailScreenDestination(
                            pokemon
                        )
                    )
                }
            )
        }?.onFailure { error ->
            error.message?.let { errorMessage ->
                context.showToast(errorMessage)
            }
        }
    }

}
