package com.example.proyectocafe

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectocafe.ui.theme.PoppinsFontFamily
import com.example.proyectocafe.ui.theme.ProyectoCafeTheme

class RegistroActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoCafeTheme {
                RegistroView(
                    onHomeView = {
                        startActivity(Intent(this, LoginActivity::class.java))
                    },
                    onLoginView = {
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                )

            }
        }
    }
}
@Composable
fun RegistroView(
    onHomeView: () -> Unit,
    onLoginView: () -> Unit
) {
    // Definición de colores elegantes para la paleta de café
    val cafeOscuro = Color(0xFF220C02)
    val marronCalido = Color(0xFF8B5742)
    val beigeClaro = Color(0xFFE3C9AD)

    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        // Imagen de fondo con una capa sutil de opacidad si se desea oscurecer un poco
        Image(
            painter = painterResource(R.drawable.fondo_principal),
            contentDescription = "Fondo de login",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 32.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1f))

            // Título principal con estilo elegante
            Text(
                text = stringResource(R.string.sign_up),
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsFontFamily,
                fontSize = 36.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(bottom = 24.dp)
            )

            // Campo de Correo Electrónico (OutlinedTextField estilizado)
            OutlinedTextField(
                value = "",
                onValueChange = { },
                placeholder = { Text(stringResource(R.string.enter_email), color = Color.Gray) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Email,
                        contentDescription = "Email Icon",
                        tint = marronCalido
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = marronCalido,
                    unfocusedBorderColor = cafeOscuro.copy(alpha = 0.4f),
                    focusedContainerColor = Color.White.copy(alpha = 0.85f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.75f),
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Contraseña
            OutlinedTextField(
                value = "",
                onValueChange = { },
                placeholder = { Text(stringResource(R.string.enter_password), color = Color.Gray) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = "Password Icon",
                        tint = marronCalido
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = marronCalido,
                    unfocusedBorderColor = cafeOscuro.copy(alpha = 0.4f),
                    focusedContainerColor = Color.White.copy(alpha = 0.85f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.75f)
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = "",
                onValueChange = { },
                placeholder = { Text("Confirme su contraseña", color = Color.Gray) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = "Password Icon",
                        tint = marronCalido
                    )
                },
                singleLine = true,
                shape = RoundedCornerShape(16.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = marronCalido,
                    unfocusedBorderColor = cafeOscuro.copy(alpha = 0.4f),
                    focusedContainerColor = Color.White.copy(alpha = 0.85f),
                    unfocusedContainerColor = Color.White.copy(alpha = 0.75f)
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(36.dp))

            // Botón de Inicio de Sesión Principal
            Button(
                onClick = onHomeView,
                colors = ButtonDefaults.buttonColors(
                    containerColor = marronCalido,
                    contentColor = Color.White,
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    text = stringResource(R.string.sign_up),
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = cafeOscuro.copy(alpha = 0.3f),
                    thickness = 1.dp
                )
                Text(
                    text = "O conéctate con",
                    color = cafeOscuro.copy(alpha = 0.7f),
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = cafeOscuro.copy(alpha = 0.3f),
                    thickness = 1.dp
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(onClick = { /* Acción del botón */ }) {
                    Image(
                        imageVector = Icons.Filled.Facebook,
                        contentDescription = "Icono Facebook",
                        modifier = Modifier.size(36.dp),

                        )
                }
                Spacer(modifier = Modifier.width(16.dp))
                IconButton(onClick = { /* Acción del botón */ }) {
                    Icon(
                        painter = painterResource(R.drawable.google),
                        contentDescription = "Icono Google",
                        modifier = Modifier.size(36.dp),
                        tint = Color.Unspecified
                    )
                }
            }

            Spacer(modifier = Modifier.weight(1f))

            // Texto inferior para registro
            Row(
                modifier = Modifier.padding(bottom = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Already have an account?",
                    color = cafeOscuro.copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(R.string.sign_in),
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = marronCalido,
                    fontSize = 14.sp,
                    modifier = Modifier.clickable { onLoginView() }
                )
            }
        }
    }
}