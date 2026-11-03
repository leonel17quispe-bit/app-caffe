package com.example.proyectocafe.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectocafe.R
import com.example.proyectocafe.ui.theme.PacificoFontFamily


@Composable
fun CupfulCanvas (
    texto : String = stringResource(R.string.cupfulcanvas),
    color : Color = colorResource(R.color.cafe_espresso),
    tamaño : TextUnit =  30.sp,
    grosor : FontWeight = FontWeight.Bold,
    modifier: Modifier = Modifier.padding(4.dp),
    letra : FontFamily = PacificoFontFamily
){

    Text(
        text = texto,
        fontWeight =grosor,
        fontSize = tamaño,
        fontFamily = letra,
        modifier = modifier,
        color = color
    )
}