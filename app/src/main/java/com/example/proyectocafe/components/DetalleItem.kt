package com.example.proyectocafe.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Colores basados en la imagen
val FondoOscuro = Color(0xFF1F0E05)
val FondoClaro = Color(0xFFEBD7B8)
val ColorTextoOscuro = Color(0xFF231709)
val ColorTextoSecundario = Color(0xFF6B5848)

@Composable
fun DetalleCafeScreen(
    titulo: String = "Frappuccino",
    descripcion: String = "Indulge in pure bliss with our Frappuccino! This icy concoction blends rich, smooth coffee with velvety milk, creating a refreshing symphony of flavors.",
    imagenResId: Int? = null,
    onBackClick: () -> Unit = {}
) {
    var cantidad by remember { mutableIntStateOf(1) }
    var esFavorito by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoClaro)
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1.2f)
                .background(FondoOscuro)
        ) {
            IconButton(
                onClick = onBackClick,
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 16.dp, start = 8.dp)
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Regresar",
                    tint = Color.White
                )
            }

            // Imagen del Producto (Centro)[cite: 1]
            if (imagenResId != null) {
                Image(
                    painter = painterResource(id = imagenResId),
                    contentDescription = titulo,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 20.dp, top = 20.dp)
                )
            } else {

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(40.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Imagen de $titulo", color = Color.White)
                }
            }


            IconButton(
                onClick = { esFavorito = !esFavorito },
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp, end = 8.dp)
            ) {
                Icon(
                    imageVector = if (esFavorito) Icons.Default.Favorite else Icons.Default.FavoriteBorder,
                    contentDescription = "Favorito",
                    tint = Color.White
                )
            }
        }


        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(20.dp)
        ) {

            Row(
                modifier = Modifier
                    .border(1.dp, ColorTextoOscuro, RoundedCornerShape(4.dp))
                    .padding(horizontal = 4.dp, vertical = 2.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = { cantidad++ },
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Aumentar",
                        tint = ColorTextoOscuro,
                        modifier = Modifier.size(16.dp)
                    )
                }

                Text(
                    text = "$cantidad",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = ColorTextoOscuro,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )

                IconButton(
                    onClick = { if (cantidad > 1) cantidad-- },
                    modifier = Modifier.size(28.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Remove,
                        contentDescription = "Disminuir",
                        tint = ColorTextoOscuro,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Título[cite: 1]
            Text(
                text = titulo,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = ColorTextoOscuro
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Descripción[cite: 1]
            Text(
                text = descripcion,
                fontSize = 14.sp,
                lineHeight = 20.sp,
                color = ColorTextoSecundario
            )
        }
    }
}