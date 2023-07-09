@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pokecards.view.composables

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokecards.model.dto.sorting.Sorting

fun LazyListScope.SortingOptions(
    sortings: List<Sorting> = Sorting.values().toList(),
    selectedSorting: Sorting,
    onSortSelected: (Sorting) -> Unit,
) {

    items(sortings) {
        FilterChip(
            modifier = Modifier.padding(all = 5.dp),
            selected = it == selectedSorting,
            onClick = {
                onSortSelected(it)
            }, label = {
                Text(text = it.name, fontSize = 12.sp)
            })
    }
}