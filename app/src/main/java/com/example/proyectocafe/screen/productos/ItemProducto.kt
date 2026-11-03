package com.example.proyectocafe.screen.productos

import android.annotation.SuppressLint
import android.content.res.Resources
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import com.example.proyectocafe.models.Producto


private val BARNER_URL =
    "https://alex273.alwaysdata.net/imgProducto/"

@Composable
fun ItemProducto(producto : Producto,
    ondetalle : (Int) -> Unit

) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.cafe_crema_claro)),
        border = BorderStroke(1.dp, colorResource(R.color.cafe_oscuro_principal)),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
            ) {
                if(LocalInspectionMode.current) {
                    Image(
                        painter = painterResource(R.drawable.taza_cafe),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {

                        AsyncImage(
                            model = ImageRequest.Builder(LocalContext.current)
                                .data(BARNER_URL + producto.nombre + ".jpg")
                                .crossfade(true)
                                .build(),
                            contentDescription = null,
                            modifier = Modifier.fillMaxSize(),
                            contentScale = ContentScale.Crop,
                            placeholder =  painterResource(R.drawable.taza_cafe),
                            error =  painterResource(R.drawable.taza_cafe)
                        )

                }
                var isFavorite by remember { mutableStateOf(false)}

                IconButton(
                    onClick = {
                        isFavorite = !isFavorite
                    },
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(4.dp)
                        .size(32.dp)
                ) {
                    if (isFavorite){
                        Icon(
                            imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favorito",
                            tint = Color.Red // Cambia el color a rojo si es favorito
                        )
                    }else{
                        Icon(
                            imageVector = if (isFavorite) Icons.Outlined.FavoriteBorder else Icons.Outlined.FavoriteBorder,
                            contentDescription = "Favorito",
                            tint =  Color.Black // Cambia el color a rojo si es favorito
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = producto.nombre,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.Black,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$ " + producto.precio.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black
                )

                IconButton(
                    onClick = {  },
                    modifier = Modifier
                        .size(32.dp)
                        .background(color = colorResource(R.color.cafe_oscuro_principal), shape = CircleShape)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Agregar",
                        tint = Color.White,
                        modifier = Modifier.size(18.dp)
                    )
                }
            }
        }
    }
}

@Composable
fun ItemProductoHome (producto : Producto) {
    Card(
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(R.color.cafe_crema_claro)),
        border = BorderStroke(1.dp, colorResource(R.color.cafe_oscuro_principal)),
        modifier = Modifier.width(150.dp)
    ) {
        Column(
            modifier = Modifier.padding(10.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White)
            ) {
                if(LocalInspectionMode.current) {
                    Image(
                        painter = painterResource(R.drawable.taza_cafe),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(BARNER_URL + producto.nombre + ".jpg")
                            .crossfade(true)
                            .build(),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                        placeholder =  painterResource(R.drawable.taza_cafe),
                        error =  painterResource(R.drawable.taza_cafe)
                    )
                }


            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = producto.nombre,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
                color = Color.Black,
                maxLines = 1
            )

            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$ " + producto.precio.toString(),
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.Black
                )

            }
        }
    }
}


