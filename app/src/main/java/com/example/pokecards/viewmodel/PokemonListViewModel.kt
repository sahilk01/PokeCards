package com.example.pokecards.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.core.ErrorUtil
import com.example.network.NetworkUtil
import com.example.pokecards.R
import com.example.pokecards.model.dto.Pokemon
import com.example.pokecards.model.usecase.PokemonListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PokemonListViewModel @Inject constructor(
    private val errorUtil: ErrorUtil,
    private val pokemonListUseCase: PokemonListUseCase,
    private val networkUtil: NetworkUtil
) : ViewModel() {

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
                            _pokemonList.emit(Result.success(pokes.pokemonList))
                        } ?: setError()
                    }
            } else {
                _pokemonList.emit(Result.failure(Throwable(errorUtil.networkError)))
            }
        }
    }

    private suspend fun setError() {
        _pokemonList.emit(Result.failure(Throwable(errorUtil.universalError)))
    }
}