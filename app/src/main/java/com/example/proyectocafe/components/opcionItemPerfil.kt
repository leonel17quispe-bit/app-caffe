package com.example.proyectocafe.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Badge
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OpcionPerfilItem(
    texto: String,
    icono: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    // Definimos los colores acorde a la pantalla de Profile
    val colorFondo = Color(0xFFF6ECE0)        // Tono crema claro del ítem
    val colorTexto = Color(0xFF3E2723)        // Marrón oscuro para icono y texto
    val colorDivisor = Color(0xFFD4B59D).copy(alpha = 0.6f) // Línea separadora sutil


    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 14.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icono,
                contentDescription = texto,
                tint = colorTexto,
                modifier = Modifier.size(22.dp)
            )

            Spacer(modifier = Modifier.width(12.dp))

            Text(
                text = texto,
                fontSize = 15.sp,
                fontWeight = FontWeight.SemiBold,
                color = colorTexto
            )
        }


            Divider(
                color = colorDivisor,
                thickness = 1.dp,
                modifier = Modifier.padding(horizontal = 8.dp)
            )

    }
}

@Preview(showBackground = true, backgroundColor = 0xFFD8C3B0)
@Composable
fun PreviewOpcionPerfil() {
    Column(modifier = Modifier.padding(16.dp)) {
        OpcionPerfilItem(
            texto = "Account Details",
            icono = Icons.Outlined.Badge,
            onClick = {}
        )
    }
}