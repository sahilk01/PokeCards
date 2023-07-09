package com.example.pokecards.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.pokecards.model.dto.Attack

@Composable
fun AttackCard(
    modifier: Modifier = Modifier,
    attack: Attack
) {
    Card(
        modifier = modifier.padding(end = 10.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        colors = CardDefaults.cardColors(Color.White),
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            attack.name?.let { name ->
                Text(text = name, fontWeight = FontWeight.Bold)
            }

            attack.damage?.let { damage ->
                Spacer(modifier = Modifier.height(8.dp))
                Row {
                    Text(text = stringResource(id = com.example.palette.R.string.damage), fontSize = 12.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = damage, fontSize = 12.sp)
                }
            }

            attack.cost?.let {
                Spacer(modifier = Modifier.height(8.dp))

                Row {
                    Text(
                        text = stringResource(id = com.example.palette.R.string.cost),
                        fontSize = 12.sp
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    it.forEach { cost ->
                        Text(text = "$cost,", color = Color.Gray, fontSize = 12.sp)
                        Spacer(modifier = Modifier.width(4.dp))
                    }
                }
            }
        }
    }
}