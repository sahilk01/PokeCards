@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.pokecards.view.composables
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokecards.model.dto.filter.Filterings

fun LazyListScope.FilterOptions(
    filters: Map<Filterings, Boolean>,
    onFilterSelected: (Pair<Filterings, Boolean>) -> Unit,
) {
        items(filters.toList()) {
            FilterChip(
                modifier = Modifier.padding(all = 5.dp),
                selected = it.second,
                onClick = {
                    onFilterSelected(it.copy(second = !it.second))
                }, label = {
                    Text(text = it.first.name, fontSize = 12.sp)
                })
        }
}
