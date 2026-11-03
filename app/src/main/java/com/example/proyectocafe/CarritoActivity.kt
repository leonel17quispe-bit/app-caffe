package com.example.proyectocafe

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Label
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
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
import com.example.proyectocafe.components.CoffeeBottomBar
import com.example.proyectocafe.components.CupfulCanvas
import com.example.proyectocafe.components.TarjetaCantidadCafeItem
import com.example.proyectocafe.components.fondo
import com.example.proyectocafe.screen.categorias.CategoriaUiState
import com.example.proyectocafe.screen.categorias.CategoriaViewModel
import com.example.proyectocafe.screen.productos.ProductoUiState
import com.example.proyectocafe.screen.productos.ProductoViewModel
import com.example.proyectocafe.ui.theme.ProyectoCafeTheme

class CarritoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // val viewModel = ViewModelProvider(this)[ProductoViewModel::class.java]
        //val viewModelCategoria = ViewModelProvider(this)[CategoriaViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            //val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            ///val uiStateC by viewModelCategoria.uiStateC.collectAsStateWithLifecycle()
            var selectedTab by remember { mutableIntStateOf(3) }

            ProyectoCafeTheme {
                CarritoView(
                    //uiState = uiState,
                    //uiStateC = uiStateC,
                    //onReintentar = { viewModel.fetchCategoria() },
                    selectedTab = selectedTab,
                    onTabSelected = { newIndex ->
                        when (newIndex) {
                            0 -> {
                                selectedTab = 0
                                val intent = Intent(this, HomeActivity::class.java)
                                startActivity(intent)
                            }
                            1 -> {
                                selectedTab = 1
                                val intent = Intent(this, MenuActivity::class.java)
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
fun CarritoView(
    //uiState : ProductoUiState,
    //uiStateC: CategoriaUiState,
    //onReintentar: () -> Unit,
    selectedTab: Int,
    onTabSelected : (Int) -> Unit
){

    Scaffold(
        bottomBar = {
            CoffeeBottomBar(
                selectedItemIndex =  selectedTab    ,
                onItemSelected = onTabSelected
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
                .fillMaxSize()
        ) {
           fondo(
               painterResource(R.drawable.fondo_marca_agua),
               "",
               ContentScale.Crop
           )
            Column(
                modifier = Modifier.padding(top = 15.dp , start = 10.dp, end = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

               CupfulCanvas()

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text("My cart", fontWeight = FontWeight.Bold)
                }
                CartItem()
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Promo code")
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(R.color.cafe_grisaceo) // <--- El color se define aquí en el Button
                        )
                    ) {
                        Text(
                            text = "Apply",
                            color = Color.White // El texto se queda en blanco limpio, sin fondos extraños
                        )
                    }
                }
                TextButton(
                    onClick = {},
                    modifier = Modifier.width(300.dp),
                    shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.textButtonColors(
                        containerColor = Color.Black
                    )
                ) {
                    Text(
                        text = "Check Out",
                        color = Color.White
                    )
                }

            }

        }

    }

}

@Composable
fun CartItem(){
    var cantidadItem by remember { mutableStateOf(1) }
    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.Center
    ) { item {


        TarjetaCantidadCafeItem(
            titulo = "Frappuccino",
            detalles = "Small, Oat Milk",
            precio = "₹ 400",
            cantidad = cantidadItem,
            imagenCafe = painterResource(R.drawable.taza_cafe), // Reemplaza con tu recurso
            onIncrementar = { cantidadItem++ },
            onDecrementar = { if (cantidadItem > 1) cantidadItem-- }
        )


    }

    }
}

