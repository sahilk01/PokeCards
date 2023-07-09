package com.example.pokecards.viewmodel

import androidx.lifecycle.ViewModel
import com.example.pokecards.model.dto.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PokemonDetailViewModel @Inject constructor(): ViewModel() {
    var selectedPokemon: Pokemon? = null
}