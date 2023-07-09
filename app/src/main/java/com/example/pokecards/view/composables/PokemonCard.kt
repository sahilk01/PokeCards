package com.example.pokecards.view.composables

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.pokecards.model.dto.Pokemon

@Composable
fun PokemonCard(
    modifier: Modifier = Modifier,
    pokemon: Pokemon,
    onClick: ((Pokemon) -> Unit?)? = null
) {
    Box(
        modifier = modifier
            .padding(10.dp)
            .clip(shape = RoundedCornerShape(18.dp))
            .clickable {
                onClick?.invoke(pokemon)
            }
    ) {
        Card {
            Column {

                AsyncImage(
                    model = pokemon.images.large,
                    contentDescription = stringResource(id = com.example.palette.R.string.pokemon_image),
                )

//                Text(text = pokemon.name)
//                Text(text = "asda")
//                Text(text = pokemon.level.orEmpty())
//                Text(text = pokemon.hp)
            }
        }

    }
}