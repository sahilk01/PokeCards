@file:OptIn(ExperimentalComposeUiApi::class)

package com.example.pokecards.view.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.palette.R
import com.example.pokecards.ui.theme.LightGray
import com.example.pokecards.ui.theme.MidLightGray
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.milliseconds

@Composable
fun SearchField(
    modifier: Modifier = Modifier,
    onBackPress: () -> Unit,
    onSearch: (String) -> Unit,
) {
    var searchText by remember {
        mutableStateOf(TextFieldValue(""))
    }

    val scope = rememberCoroutineScope()
    var searchJob: Job? by remember {
        mutableStateOf(null)
    }

   Row(
       modifier = modifier
           .padding(6.dp)
           .background(color = MidLightGray, shape = RoundedCornerShape(8.dp)),
       verticalAlignment = Alignment.CenterVertically
   ) {
       Spacer(modifier = Modifier.padding(start = 10.dp))

       PokeTextField(
           value = searchText, placeholder = stringResource(id = R.string.search), onValueChange = {
               searchText = it
               searchJob?.cancel()
               searchJob = scope.launch {
                   delay(searchDelayTime)
                   onSearch(it.text)
               }
           },
           keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done)
       )

       Spacer(modifier = Modifier.padding(end = 10.dp))
   }
}

private val searchDelayTime = 500.milliseconds