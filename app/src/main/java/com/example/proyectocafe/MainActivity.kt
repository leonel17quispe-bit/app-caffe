package com.example.proyectocafe

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectocafe.components.fondo
import com.example.proyectocafe.ui.theme.EstiloCup
import com.example.proyectocafe.ui.theme.EstiloSc
import com.example.proyectocafe.ui.theme.EstiloWl
import com.example.proyectocafe.ui.theme.LobsterFonFamily
import com.example.proyectocafe.ui.theme.MontserratFonFamily
import com.example.proyectocafe.ui.theme.PacificoFontFamily
import com.example.proyectocafe.ui.theme.PoppinsFontFamily
import com.example.proyectocafe.ui.theme.ProyectoCafeTheme
import kotlinx.coroutines.CoroutineStart

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoCafeTheme {
                    HomeView(
                        onLoginStart ={
                            startActivity(Intent(this, LoginActivity::class.java))
                        }
                    )
            }
        }
    }
}

@Composable
fun HomeView(
    onLoginStart: () -> Unit
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp, bottom = 50.dp, start = 20.dp, end = 20.dp)
            .navigationBarsPadding()
    ){
        fondo(
            painterResource(R.drawable.fondo1),
            descripcion = "Fondo Principal",
            ContentScale.Fit
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(R.string.welcome_to),
                    style = EstiloWl,
                    color = colorResource(R.color.cafe_grisaceo),
                    modifier = Modifier.align(Alignment.Start)
                )

                Text(
                    text = stringResource(R.string.cupfulcanvas),
                    style = EstiloCup,
                    color=colorResource(R.color.cafe_espresso),
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                Text(
                    text = stringResource(R.string.Sip_Smile_Create),
                   style = EstiloSc,
                    color = colorResource(R.color.cafe_grisaceo),
                    modifier = Modifier.align(Alignment.End)
                )
            }//column
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier= Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Button(
                    onClick = onLoginStart,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(R.color.cafe_medio),
                        contentColor = Color.White,

                        ),
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.width(220.dp).height(80.dp)
                ) {
                    Text(
                        text = stringResource(R.string.get_start),
                        fontSize = 20.sp

                    )
                }
            }
        }


    }//box

}

