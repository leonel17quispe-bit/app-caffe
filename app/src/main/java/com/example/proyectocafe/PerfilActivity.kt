package com.example.proyectocafe

import android.content.Intent
import android.icu.text.CaseMap
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.style.styleable
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.EditCalendar
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Badge
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil3.Image
import com.example.proyectocafe.components.CoffeeBottomBar
import com.example.proyectocafe.components.CupfulCanvas
import com.example.proyectocafe.components.OpcionPerfilItem
import com.example.proyectocafe.components.fondo
import com.example.proyectocafe.screen.categorias.CategoriaUiState
import com.example.proyectocafe.screen.categorias.CategoriaViewModel
import com.example.proyectocafe.screen.productos.ProductoUiState
import com.example.proyectocafe.screen.productos.ProductoViewModel
import com.example.proyectocafe.ui.theme.ProyectoCafeTheme

class PerfilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[ProductoViewModel::class.java]
        val viewModelCategoria = ViewModelProvider(this)[CategoriaViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiStateC by viewModelCategoria.uiStateC.collectAsStateWithLifecycle()
            var selectedTab by remember { mutableIntStateOf(4) }
            ProyectoCafeTheme {
                PerfilView(
                    uiState = uiState,
                    uiStateC = uiStateC,
                    onReintentar = { viewModel.fetchCategoria() },
                    selectedTab = selectedTab,
                    onTabSelected = { newIndex ->
                        when (newIndex) {
                            0 -> {
                                selectedTab = 0
                                val intent = Intent(this, InicioActivity::class.java)
                                startActivity(intent)
                            }
                            1 -> {
                                selectedTab = 1
                                val intent = Intent(this, HomeActivity::class.java)
                                startActivity(intent)
                            }
                            2 -> {
                                selectedTab = 2
                                val intent = Intent(this, FavoritoActivity::class.java)
                                startActivity(intent)
                            }
                            3 -> {
                                selectedTab = 3
                                val intent = Intent(this, CarritoActivity::class.java)
                                startActivity(intent)
                            }
                            4 -> {
                                selectedTab = 4
                                val intent = Intent(this, PerfilActivity::class.java)
                                startActivity(intent)
                            }
                        }
                    }
                )
            }
        }
    }



}

@Composable
fun PerfilView(
    uiState : ProductoUiState,
    uiStateC: CategoriaUiState,
    onReintentar: () -> Unit,
    selectedTab: Int,
    onTabSelected : (Int) -> Unit

){
    Scaffold(
        bottomBar = {
            CoffeeBottomBar(
                selectedItemIndex = selectedTab,
                onItemSelected = onTabSelected
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize()
        ){
            fondo(
                painterResource(R.drawable.fondo_perfil),
                "",
                ContentScale.Crop
            )
        }
        Column(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 100.dp , start = 10.dp, end = 10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CupfulCanvas(
                color = Color.White,
                grosor = FontWeight.Normal
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Profile", fontSize = 20.sp, color = Color.White)
                Icon(
                    imageVector = Icons.Filled.EditCalendar
                    , contentDescription = null, tint = Color.White,
                    modifier = Modifier.size(20.dp)
                )
            }
            Row(
                modifier = Modifier.height(150.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = null,

                    tint = Color.White,
                    modifier = Modifier.size(32.dp)
                )
                Column() {
                    Text("Saanvi Sharma", color = Color.White)
                    Row() {
                        Icon(
                            imageVector = Icons.Filled.Money,
                            contentDescription = null
                            , tint = Color.Yellow
                        )
                        Text("98 coins", color = Color.White)
                    }
                }


            }
            Spacer(Modifier.height(60.dp))
            Column(
                modifier = Modifier.verticalScroll(rememberScrollState())
                .navigationBarsPadding()
                    .padding(top = 35.dp, start = 10.dp, end = 10.dp, bottom = 150.dp),
            ) {

                OptionsItem("Acount")
                OptionsItem("Orders")
                OptionsItem("Settings")

            }
        }
    }


}


@Composable
fun OptionsItem(
title: String
    ){

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,

    ) {
        Text(title,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold
            )
    }
    Column(
        modifier = Modifier.background(colorResource(R.color.cafe_fondo_suave),
            shape = RoundedCornerShape(16.dp)
        )
    ) {
        OpcionPerfilItem(
            texto = "Account Details",
            icono = Icons.Outlined.Badge,
            onClick = {}
        )
        OpcionPerfilItem(
            texto = "Account Details",
            icono = Icons.Outlined.Badge,
            onClick = {}
        )
        OpcionPerfilItem(
            texto = "Account Details",
            icono = Icons.Outlined.Badge,
            onClick = {}
        )
    }

}
