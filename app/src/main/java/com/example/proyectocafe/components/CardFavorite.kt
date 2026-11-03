package com.example.proyectocafe.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.res.painterResource

@Composable
fun TarjetaCafeItem(
    titulo: String,
    detalles: String,
    precio: String,
    imagenCafe: Painter ,
    onAgregarClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val colorFondoTarjeta = Color(0xFFF9EFE6)
    val colorBorde = Color(0xFFD4B59D)
    val colorTextoPrincipal = Color(0xFF3E2723)
    val colorTextoSecundario = Color(0xFF795548)
    val colorBotonOrganico = Color(0xFF2C150B)

    Card(
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = colorFondoTarjeta),
        border = BorderStroke(1.dp, colorBorde),
        modifier = modifier
            .fillMaxWidth()
            .height(100.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Contenedor izquierdo: Imagen con fondo blanco redondeado
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(84.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color.White),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = imagenCafe,
                    contentDescription = titulo,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.width(12.dp))

            // Contenedor central: Títulos y Precio
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = titulo.uppercase(),
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorTextoPrincipal,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = detalles,
                    fontSize = 12.sp,
                    color = colorTextoSecundario,
                    maxLines = 1
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = precio,
                    fontSize = 15.sp,
                    fontWeight = FontWeight.Bold,
                    color = colorTextoPrincipal
                )
            }

            // Contenedor derecho: Botón con forma orgánica y el ícono de "+"
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(72.dp),
                contentAlignment = Alignment.CenterEnd
            ) {
                IconButton(
                    onClick = onAgregarClick,
                    modifier = Modifier
                        .size(width = 64.dp, height = 72.dp)
                        // Simulamos la forma orgánica/asomada de la imagen original con RoundedCornerShape asimétrico
                        .clip(
                            RoundedCornerShape(
                                topStart = 32.dp,
                                topEnd = 16.dp,
                                bottomStart = 32.dp,
                                bottomEnd = 16.dp
                            )
                        )
                        .background(colorBotonOrganico)
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Agregar",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}

