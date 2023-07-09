package com.example.pokecards.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.ErrorUtil
import com.example.network.NetworkUtil
import com.example.pokecards.model.dto.Pokemon
import com.example.pokecards.model.dto.filter.Filterings
import com.example.pokecards.model.dto.sorting.Sorting
import com.example.pokecards.model.usecase.PokemonListUseCase
import com.example.pokecards.util.SortingUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val errorUtil: ErrorUtil,
    private val pokemonListUseCase: PokemonListUseCase,
    private val networkUtil: NetworkUtil,
    private val sortingUtil: SortingUtil,
) : ViewModel() {

    private val _loading = MutableStateFlow(true)
    val loading get() = _loading.asStateFlow()

    private var pokemonsList: List<Pokemon>? = null

    private val _sorting = MutableStateFlow(Sorting.NONE)
    val sorting get() = _sorting.asStateFlow()

    private val _sortedBy = MutableStateFlow(Filterings.filters)
    val sortedBy get() = _sortedBy.asStateFlow()

    private var searchQuery = ""

    private val _pokemonList = MutableStateFlow<Result<List<Pokemon>>?>(null)
    val pokemonList get() = _pokemonList.asStateFlow()

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        viewModelScope.launch {
            if (networkUtil.isNetworkAvailable()) {
                pokemonListUseCase.execute()
                    .catch {
                        setError()
                    }
                    .collect { pokemonList ->
                        pokemonList?.let { pokes ->
                            pokemonsList = pokes.pokemonList
                            _loading.emit(false)
                            _pokemonList.emit(Result.success(pokes.pokemonList))
                        } ?: setError()
                    }
            } else {
                _pokemonList.emit(Result.failure(Throwable(errorUtil.networkError)))
            }
        }
    }

    fun search(query: String) {
        searchQuery = query
        applyFilters()
    }

    fun sort(sortingType: Sorting = Sorting.NONE) {
        _sorting.value = sortingType
        applyFilters()
    }

    fun sortedBy(selected: Filterings, isSelected: Boolean) {
        val hashMap = _sortedBy.value.toMutableMap()
        hashMap[selected] = isSelected
        _sortedBy.value = hashMap.toMap()
        applyFilters()
    }

    private suspend fun setError() {
        _loading.emit(false)
        _pokemonList.emit(Result.failure(Throwable(errorUtil.universalError)))
    }

    private fun applyFilters() {
        viewModelScope.launch(Dispatchers.IO) {
            pokemonsList?.let { pokeList ->
                var filteredList = applySearch(query = searchQuery, pokeList)

                when (_sorting.value) {
                    Sorting.ASCENDING -> {
                        filteredList = sortingUtil.ascendingSort(filteredList, sortedBy.value)
                    }

                    Sorting.DESCENDING -> {
                        filteredList = sortingUtil.descendingSort(filteredList, sortedBy.value)
                    }

                    else -> Unit
                }
                _pokemonList.emit(Result.success(filteredList.toList()))
            }
        }
    }

    private fun applySearch(query: String, pokeList: List<Pokemon>): List<Pokemon> {
        return pokeList.filter {
            it.name?.lowercase().orEmpty().contains(searchQuery.lowercase())
        }
    }

}


