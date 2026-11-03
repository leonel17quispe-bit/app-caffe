package com.example.proyectocafe.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import coil3.Image
import com.example.proyectocafe.R

@Composable
fun fondo(
    fondo : Painter,
    descripcion  : String,
    scala : ContentScale,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Image(
        painter = fondo,
        contentDescription = descripcion,
        contentScale = scala,
        modifier = modifier
    )
}