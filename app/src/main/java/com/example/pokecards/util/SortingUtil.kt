package com.example.pokecards.util

import com.example.pokecards.model.dto.Pokemon
import com.example.pokecards.model.dto.filter.Filterings
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SortingUtil @Inject constructor() {

    fun descendingSort(pokemonList: List<Pokemon>, sortedBy: Map<Filterings, Boolean>): List<Pokemon> {
        var filteredList = pokemonList
        if (sortedBy[Filterings.HP] == true && sortedBy[Filterings.LEVEL] == true) {
            filteredList = filteredList.sortedByDescending {
                it.hp?.toInt()?.plus(it.level?.toInt() ?: 0)
            }
        } else if (sortedBy[Filterings.HP] == true) {
            filteredList = filteredList.sortedByDescending {
                it.hp?.toInt() ?: 0
            }
        } else if (sortedBy[Filterings.LEVEL] == true) {
            filteredList = filteredList.sortedByDescending {
                it.level?.toInt() ?: 0
            }
        }
        return filteredList
    }

    fun ascendingSort(pokemonList: List<Pokemon>, sortedBy: Map<Filterings, Boolean>): List<Pokemon> {
        var filteredList = pokemonList
        if (sortedBy[Filterings.HP] == true && sortedBy[Filterings.LEVEL] == true) {
            filteredList = filteredList.sortedBy {
                it.hp?.toInt()?.plus(it.level?.toInt() ?: 0)
            }
        } else if (sortedBy[Filterings.HP] == true) {
            filteredList = filteredList.sortedBy {
                it.hp?.toInt() ?: 0
            }
        } else if (sortedBy[Filterings.LEVEL] == true) {
            filteredList = filteredList.sortedBy {
                it.level?.toInt() ?: 0
            }
        }
        return filteredList
    }
}