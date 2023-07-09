@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.pokecards.view.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.pokecards.R
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
            .background(color = Color.White)
    ) {
        Card(
            shape = RoundedCornerShape(18.dp),
            elevation = CardDefaults.cardElevation(6.dp),
            colors = CardDefaults.cardColors(Color.White),
            onClick = {
                onClick?.invoke(pokemon)
            }
        ) {

            Column {

                AsyncImage(
                    model = pokemon.images?.large,
                    contentDescription = stringResource(id = com.example.palette.R.string.pokemon_image),
                )

                Column(
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 8.dp)
                ) {

                    Text(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(CenterHorizontally),
                        textAlign = TextAlign.Center,
                        text = pokemon.name.orEmpty(),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                            TextWithIcon(
                                icon = painterResource(id = com.example.palette.R.drawable.hp), text = pokemon.hp.orEmpty()
                            )
                        pokemon.level?.let {level ->
                            TextWithIcon(
                                icon = painterResource(id = com.example.palette.R.drawable.level), text = level
                            )
                        }

                    }
                    Spacer(modifier = modifier.height(4.dp))
                    Row {
                        pokemon.types?.forEach { type ->
                            Text(
                                modifier = Modifier.padding(end = 4.dp),
                                text = type,
                                color = Color.Gray,
                                fontSize = 12.sp
                            )
                        }
                    }
                }
            }
        }
    }
}