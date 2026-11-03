package com.example.proyectocafe.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectocafe.R
import com.example.proyectocafe.R.color
import com.example.proyectocafe.R.color.cafe_grisaceo

// Set of Material typography styles to start with
val PoppinsFontFamily = FontFamily(
    Font(R.font.popping_bold)
)
val LobsterFonFamily = FontFamily(
    Font(R.font.lobter_regular)
)
val MontserratFonFamily= FontFamily(
    Font(R.font.montserrat_bold, FontWeight.Bold),
    Font(R.font.montserrat_semibold, FontWeight.SemiBold)
)

val RobotoFonFamily = FontFamily(
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_semibold, FontWeight.SemiBold)
)
val PacificoFontFamily= FontFamily(
     Font(R.font.pacifico_regular, FontWeight.Normal)
)

val EstiloWl = TextStyle(
    fontFamily = MontserratFonFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 24.sp,
)
val EstiloCup = TextStyle(
    fontFamily = PacificoFontFamily,
    fontWeight = FontWeight.Normal,
    fontSize = 46.sp
)

val EstiloSc = TextStyle(
    fontFamily = MontserratFonFamily,
    fontWeight = FontWeight.SemiBold,
    fontSize = 22.sp
)
