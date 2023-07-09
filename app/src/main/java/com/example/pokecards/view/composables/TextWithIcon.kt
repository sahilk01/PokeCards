package com.example.pokecards.view.composables

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.palette.R

@Composable
fun TextWithIcon(
    modifier: Modifier = Modifier,
    iconSize: Dp = 12.dp,
    textSize: TextUnit = 12.sp,
    icon: Painter,
    text: String,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(iconSize),
            painter = icon,
            contentDescription = stringResource(
                id = R.string.text_icon
            )
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = text, fontSize = textSize)
    }
}