package com.example.proyectocafe.screen.categorias

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import coil3.request.ImageRequest
import coil3.request.crossfade
import com.example.proyectocafe.R
import com.example.proyectocafe.models.Categoria


private val BARNER_URL =
    "https://alex273.alwaysdata.net/imgCategoria/"
@Composable
fun itemCategoria(
    categoria : Categoria
){
    Box(
        modifier = Modifier
            .shadow(2.dp, RoundedCornerShape(32.dp))
            .clip(RoundedCornerShape(32.dp))
            .background(colorResource(R.color.cafe_medio))
            .border(
                width = 2.dp,
                color = colorResource(R.color.cafe_espresso),
                shape = RoundedCornerShape(32.dp)
            )
            .padding(horizontal = 8.dp, vertical = 8.dp),
        contentAlignment = Alignment.Center
    ){
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if(LocalInspectionMode.current) {
                Image(
                    painter = painterResource(R.drawable.taza_cafe),
                    contentDescription = null,
                    modifier = Modifier.height(20.dp),
                    contentScale = ContentScale.Fit
                )
            } else {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(BARNER_URL + categoria.nombre + ".jpg")
                        .crossfade(true)
                        .build(),
                    contentDescription = null,
                    modifier = Modifier.size(36.dp),
                    contentScale = ContentScale.Fit,
                    placeholder =  painterResource(R.drawable.taza_cafe),
                    error =  painterResource(R.drawable.taza_cafe)
                )
            }
            Text(
                text = categoria.nombre ,
                color = colorResource(R.color.white),
                fontFamily = MaterialTheme.typography.titleMedium.fontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                lineHeight = 22.sp
            )
        }
    }
}