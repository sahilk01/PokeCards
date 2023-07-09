package com.example.pokecards.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokecards.R
import com.example.pokecards.model.dto.Attack
import com.example.pokecards.model.dto.Weaknesse
import kotlin.math.cos

@Composable
fun WeaknessCard(
    modifier: Modifier = Modifier,
    weakness: Weaknesse
) {
    Card(
        modifier = modifier
            .padding(end = 10.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Row(
            modifier = Modifier.padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            weakness.type?.let { type ->
                Text(text = type, fontWeight = FontWeight.Bold)
            }

            weakness.value?.let { value ->
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = value, fontSize = 12.sp)
            }
        }
    }
}