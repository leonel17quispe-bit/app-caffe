package com.example.proyectocafe.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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

@Composable
fun TarjetaCantidadCafeItem(
    titulo: String,
    detalles: String,
    precio: String,
    cantidad: Int,
    imagenCafe: Painter,
    onIncrementar: () -> Unit,
    onDecrementar: () -> Unit,
    modifier: Modifier = Modifier
) {
    // Definición de colores acordes a tu paleta de café
    val colorFondoTarjeta = Color(0xFFF9EFE6) // Tono crema claro
    val colorBorde = Color(0xFFD4B59D)        // Marrón suave para bordes
    val colorTextoPrincipal = Color(0xFF3E2723) // Marrón oscuro
    val colorTextoSecundario = Color(0xFF795548) // Marrón medio
    val colorContenedorControl = Color(0xFFEEDCC5) // Tono para la caja de cantidad

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
            // 1. Imagen izquierda con fondo blanco redondeado
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

            // 2. Información central (Título, Detalles y Precio)
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = titulo,
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

            // 3. Control de cantidad derecho [+  1  -]
            Surface(
                shape = RoundedCornerShape(12.dp),
                color = colorContenedorControl,
                border = BorderStroke(1.dp, colorBorde),
                modifier = Modifier.height(40.dp)
            ) {
                Row(
                    modifier = Modifier.padding(horizontal = 4.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    TextButton(
                        onClick = onIncrementar,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.size(32.dp)
                    ) {
                        Text(text = "+", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = colorTextoPrincipal)
                    }

                    Text(
                        text = cantidad.toString(),
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        color = colorTextoPrincipal,
                        modifier = Modifier.padding(horizontal = 8.dp)
                    )

                    TextButton(
                        onClick = onDecrementar,
                        contentPadding = PaddingValues(0.dp),
                        modifier = Modifier.size(32.dp)
                    ) {
                        Text(text = "-", fontSize = 18.sp, fontWeight = FontWeight.Bold, color = colorTextoPrincipal)
                    }
                }
            }
        }
    }
}