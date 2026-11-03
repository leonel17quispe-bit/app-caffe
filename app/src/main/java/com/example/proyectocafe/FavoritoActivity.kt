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
import androidx.compose.foundation.layout.Grid
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
import com.example.proyectocafe.components.TarjetaCafeItem
import com.example.proyectocafe.models.Producto
import com.example.proyectocafe.screen.categorias.CategoriaUiState
import com.example.proyectocafe.screen.categorias.CategoriaViewModel
import com.example.proyectocafe.screen.productos.ProductoUiState
import com.example.proyectocafe.screen.productos.ProductoViewModel
import com.example.proyectocafe.ui.theme.ProyectoCafeTheme

class FavoritoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[ProductoViewModel::class.java]
        val viewModelCategoria = ViewModelProvider(this)[CategoriaViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiStateC by viewModelCategoria.uiStateC.collectAsStateWithLifecycle()
            var selectedTab by remember { mutableIntStateOf(2) }
            ProyectoCafeTheme {

                FavoritosView (
                    uiState = uiState,
                    uiStateC = uiStateC,
                    onReintentar = { viewModel.fetchCategoria() },
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
fun FavoritosView(
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
           Image(
               painter = painterResource(R.drawable.fondo_marca_agua),
               contentScale = ContentScale.Crop,
               contentDescription = "fondo",
               modifier = Modifier.fillMaxSize()
           )

           Column(
               modifier = Modifier.fillMaxWidth()
                   .padding(top = 15.dp, end = 10.dp, start = 10.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
           ) {
               CupfulCanvas()
               Row(
                   modifier = Modifier.align(Alignment.End)
               ) {

                   Text(
                       text = " items "
                   )


               }
               TarjetaCafeItem(
                   titulo = "COLD BREW",
                   detalles = "Large, Almond Milk",
                   precio = "₹ 280",
                   imagenCafe = painterResource(R.drawable.taza_cafe),
                   onAgregarClick = {}
               )

           }


       }


   }

}

@Composable
fun ItemFavoritos(){

    LazyVerticalGrid(
        columns = GridCells.Fixed(1),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        horizontalArrangement = Arrangement.Center,
    ) {
      item {
          Card(
              colors = CardDefaults.cardColors(
                  colorResource(R.color.cafe_fondo_suave)
              ),
              modifier = Modifier.height(100.dp)
                  , border = BorderStroke(2.dp ,colorResource(R.color.cafe_espresso))
          ) {
              Row() {
                  Image(
                      painter = painterResource(R.drawable.taza_cafe)
                      , contentDescription = null,
                  )
                  Column(
                      modifier = Modifier.padding(start = 10.dp,top = 10.dp),

                  ) {
                      Text("CAFE LATTE")
                      Text("descripcio")
                      Text("Precio")
                  }
                  Spacer(modifier = Modifier.width(100.dp))
                  Column(
                      modifier = Modifier.padding(10.dp)
                          .background(colorResource(R.color.cafe_espresso)),
                     horizontalAlignment = Alignment.End
                  ) {
                      Text(
                          text = "+",
                          fontSize = 30.sp,
                          modifier = Modifier.padding(10.dp)
                              .align(Alignment.End)
                          ,
                          color = colorResource(R.color.white)
                      )
                  }
              }
          }
      }
    }



}