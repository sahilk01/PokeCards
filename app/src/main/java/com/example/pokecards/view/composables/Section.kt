package com.example.pokecards.view.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.palette.R

@Composable
fun Section(
    sectionConfiguration: SectionConfiguration
) {
    Spacer(modifier = Modifier.height(10.dp))

    HeadingWithIcon(
        icon = sectionConfiguration.icon,
        text = sectionConfiguration.heading
    )
    Spacer(modifier = Modifier.height(10.dp))
    Text(text = sectionConfiguration.content, color = Color.Gray)
}

data class SectionConfiguration(
    val icon: Painter,
    val heading: String,
    val content: String,
)