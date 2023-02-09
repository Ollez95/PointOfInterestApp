package com.example.pointofinterestapp.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/**
 * Point of Interest TextField
 */
@Composable
fun PoiTextField(
    text: MutableState<String>,
    placeholder: String,
    percentageWidth: Float,
    searchStadium: (text: String) -> Unit
){

    TextField(
        placeholder = {
            Text(
                text = placeholder,
                fontStyle = FontStyle.Italic
            )
        },
        value = text.value,
        onValueChange = {
                newText ->
            text.value = newText
            searchStadium(newText)
                        },
        modifier =
        Modifier
            .fillMaxWidth(percentageWidth)
            .padding(8.dp),
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = Color.Black,
            backgroundColor = Color.White
        ))
}


@Preview
@Composable
private fun RecipeTextFieldPreview(){
    val text = rememberSaveable { mutableStateOf("") }

    PoiTextField(
        text = text,
        placeholder = "Write something...",
        percentageWidth = 1f,
        searchStadium = {}
    )
}