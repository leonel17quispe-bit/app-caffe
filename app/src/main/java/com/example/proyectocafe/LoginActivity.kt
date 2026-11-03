package com.example.proyectocafe

import CampoTextoPersonalizado
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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Facebook
import androidx.compose.material.icons.filled.Lock
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectocafe.components.fondo
import com.example.proyectocafe.ui.theme.PoppinsFontFamily
import com.example.proyectocafe.ui.theme.ProyectoCafeTheme

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoCafeTheme {
               LoginView(
                   onHomeView = {
                       startActivity(Intent(this, InicioActivity::class.java))
                   },
                   onRegistroView = {
                       startActivity(Intent(this, RegistroActivity::class.java))
                   }
               )

            }
        }
    }
}
@Composable
fun LoginView(
    onHomeView: () -> Unit,
    onRegistroView : () -> Unit
) {


    Box(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
    ) {
        fondo(
            painterResource(R.drawable.fondo_principal),
            "Fondo principal",
            ContentScale.Crop
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
                text = stringResource(R.string.sign_in),
                fontWeight = FontWeight.Bold,
                fontFamily = PoppinsFontFamily,
                fontSize = 36.sp,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(bottom = 24.dp)
            )

            // Campo de Correo Electrónico (OutlinedTextField estilizado)
           CampoTextoPersonalizado("",
               {},
               stringResource(R.string.enter_email),
               Icons.Filled.Email,

               )

            Spacer(modifier = Modifier.height(16.dp))

            // Campo de Contraseña
            CampoTextoPersonalizado("",
                {},
                stringResource(R.string.enter_password),
                Icons.Filled.Lock,

                )

            Spacer(modifier = Modifier.height(8.dp))

            // Texto ¿Olvidaste tu contraseña?
            Text(
                text = stringResource(R.string.forgot_password),
                modifier = Modifier
                    .align(Alignment.End)
                    .clickable { },
                color = colorResource(R.color.cafe_medio),
                fontWeight = FontWeight.Medium,
                fontSize = 14.sp
            )

            Spacer(modifier = Modifier.height(28.dp))

            // Botón de Inicio de Sesión Principal
            Button(
                onClick = onHomeView,
                colors = ButtonDefaults.buttonColors(
                    containerColor = colorResource(R.color.cafe_medio),
                    contentColor = Color.White,
                ),
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Text(
                    text = stringResource(R.string.sign_in),
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
                    color = colorResource(R.color.cafe_oscuro_principal).copy(alpha = 0.3f),
                    thickness = 1.dp
                )
                Text(
                    text = "O conéctate con",
                    color = colorResource(R.color.cafe_oscuro_principal).copy(alpha = 0.7f),
                    fontSize = 12.sp,
                    modifier = Modifier.padding(horizontal = 12.dp)
                )
                HorizontalDivider(
                    modifier = Modifier.weight(1f),
                    color = colorResource(R.color.cafe_oscuro_principal).copy(alpha = 0.3f),
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
                    text = stringResource(R.string.don_have_acocunt),
                    color = colorResource(R.color.cafe_oscuro_principal).copy(alpha = 0.8f),
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.width(4.dp))
                Text(
                    text = stringResource(R.string.sign_up),
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    color = colorResource(R.color.cafe_medio) ,
                    fontSize = 14.sp,
                    modifier = Modifier.clickable { onRegistroView() }
                )
            }
        }
    }
}