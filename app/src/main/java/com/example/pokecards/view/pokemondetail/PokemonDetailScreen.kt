package com.example.pokecards.view.pokemondetail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.pokecards.model.dto.Ability
import com.example.pokecards.model.dto.Attack
import com.example.pokecards.model.dto.Pokemon
import com.example.pokecards.model.dto.Resistance
import com.example.pokecards.model.dto.Weaknesse
import com.example.pokecards.view.composables.AbilityCard
import com.example.pokecards.view.composables.AttackCard
import com.example.pokecards.view.composables.HeadingWithIcon
import com.example.pokecards.view.composables.ResistanceCard
import com.example.pokecards.view.composables.Section
import com.example.pokecards.view.composables.SectionConfiguration
import com.example.pokecards.view.composables.WeaknessCard
import com.example.pokecards.viewmodel.PokemonDetailViewModel
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Destination
@Composable
fun PokemonDetailScreen(
    navigator: DestinationsNavigator,
    detailViewModel: PokemonDetailViewModel = hiltViewModel(),
    selectedPokemon: Pokemon,
) {
    detailViewModel.selectedPokemon = selectedPokemon
    val scrollState = rememberScrollState()

    detailViewModel.selectedPokemon?.let { pokemon ->
        Column(
            modifier = Modifier.verticalScroll(scrollState)
        ) {
            Box {
                AsyncImage(
                    modifier = Modifier
                        .fillMaxWidth(),
                    model = pokemon.images?.large,
                    contentDescription = "pokemon image",
                    alignment = Alignment.Center,
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
            ) {
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = pokemon.name.orEmpty(), textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold
                )
                pokemon.types?.let { types ->
                    if (types.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(10.dp))

                        HeadingWithIcon(icon = painterResource(id = com.example.palette.R.drawable.type_coloured), text = stringResource(id = com.example.palette.R.string.types))

                        Spacer(modifier = Modifier.height(10.dp))
                        types.forEach { type ->
                            Text(text = type, color = Color.Gray)
                        }
                    }
                }
                pokemon.subtypes?.let { subtypes ->
                    if (subtypes.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(10.dp))
                        HeadingWithIcon(
                            icon = painterResource(id = com.example.palette.R.drawable.stage_coloured),
                            text = stringResource(id = com.example.palette.R.string.subtypes)
                        )
                        Spacer(modifier = Modifier.height(10.dp))
                        subtypes.forEach { type ->
                            Text(text = type, color = Color.Gray)
                        }
                    }
                }
                pokemon.level?.let { level ->
                    Section(sectionConfiguration = SectionConfiguration(
                        icon = painterResource(id = com.example.palette.R.drawable.level_coloured),
                        heading = stringResource(id = com.example.palette.R.string.level),
                        content = level
                    ))
                }

                pokemon.hp?.let { health ->
                    Section(sectionConfiguration = SectionConfiguration(
                        icon = painterResource(
                            id = com.example.palette.R.drawable.hp_coloured
                        ),
                        heading = stringResource(id = com.example.palette.R.string.hp),
                        content = health
                    ))
                }

                pokemon.attacks?.let { attacks ->
                    if (attacks.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(10.dp))
                        HeadingWithIcon(text = stringResource(id = com.example.palette.R.string.attacks), icon = painterResource(
                            id = com.example.palette.R.drawable.attack
                        ))
                        Spacer(modifier = Modifier.height(10.dp))
                        AttacksList(attacks = attacks)
                    }
                }

                pokemon.weaknesses?.let { weaknesses ->
                    if (weaknesses.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(10.dp))
                        HeadingWithIcon(text = stringResource(id = com.example.palette.R.string.weaknesses), icon = painterResource(
                            id = com.example.palette.R.drawable.weakness
                        ))
                        Spacer(modifier = Modifier.height(10.dp))
                        WeaknessList(weaknesses = weaknesses)
                    }
                }

                pokemon.abilities?.let { abilities ->
                    if (abilities.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(10.dp))
                        HeadingWithIcon(text = stringResource(id = com.example.palette.R.string.abilities), icon = painterResource(
                            id = com.example.palette.R.drawable.ability
                        ))
                        Spacer(modifier = Modifier.height(10.dp))
                        AbilityList(abilities = abilities)
                    }
                }

                pokemon.resistances?.let { resistance ->
                    if (resistance.isNotEmpty()) {
                        Spacer(modifier = Modifier.height(10.dp))
                        HeadingWithIcon(text = stringResource(id = com.example.palette.R.string.resistance), icon = painterResource(
                            id = com.example.palette.R.drawable.resistance
                        ))
                        Spacer(modifier = Modifier.height(10.dp))
                        ResistanceList(resistance = resistance)
                    }
                }

                Spacer(modifier = Modifier.height(20.dp))
            }
        }
    }
}

@Composable
fun AttacksList(attacks: List<Attack>) {
    LazyRow(content = {
        items(attacks) {
            AttackCard(attack = it)
        }
    })
}

@Composable
fun WeaknessList(weaknesses: List<Weaknesse>) {
    LazyRow(content = {
        items(weaknesses) {
            WeaknessCard(weakness = it)
        }
    })
}

@Composable
fun AbilityList(abilities: List<Ability>) {
    LazyRow(content = {
        items(abilities) {
            AbilityCard(ability = it)
        }
    })
}

@Composable
fun ResistanceList(resistance: List<Resistance>) {
    LazyRow(content = {
        items(resistance) {
            ResistanceCard(resistance = it)
        }
    })
}

