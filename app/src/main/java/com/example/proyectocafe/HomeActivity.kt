package com.example.proyectocafe

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Business
import androidx.compose.material.icons.outlined.Error
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.proyectocafe.components.CoffeeBottomBar
import com.example.proyectocafe.components.CupfulCanvas
import com.example.proyectocafe.components.fondo
import com.example.proyectocafe.models.Categoria
import com.example.proyectocafe.models.Producto
import com.example.proyectocafe.screen.categorias.CategoriaUiState
import com.example.proyectocafe.screen.categorias.CategoriaViewModel
import com.example.proyectocafe.screen.categorias.itemCategoria
import com.example.proyectocafe.screen.productos.ItemProducto
import com.example.proyectocafe.screen.productos.ProductoUiState
import com.example.proyectocafe.screen.productos.ProductoViewModel
import com.example.proyectocafe.ui.theme.PacificoFontFamily
import com.example.proyectocafe.ui.theme.PoppinsFontFamily
import com.example.proyectocafe.ui.theme.ProyectoCafeTheme



class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[ProductoViewModel::class.java]
        val viewModelCategoria = ViewModelProvider(this)[CategoriaViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            val uiStateC by viewModelCategoria.uiStateC.collectAsStateWithLifecycle()
            var selectedTab by remember { mutableIntStateOf(1) }

            ProyectoCafeTheme {
                HomeView(
                    uiState = uiState,
                    uiStateC = uiStateC,
                    onBackClick ={ finish() },
                    onReintentar = { viewModel.fetchCategoria() },
                    selectedTab = selectedTab,
                    onTabSelected = {
                            newIndex ->

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
fun HomeView(
    uiState : ProductoUiState,
    uiStateC: CategoriaUiState,
    onBackClick: () -> Unit,
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
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            fondo(
                painterResource(R.drawable.fondo_marca_agua),
                    "marca de agua",
                ContentScale.Crop
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 35.dp, start = 10.dp, end = 10.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                CupfulCanvas()
                Text(
                    text =  stringResource(R.string.menu),
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Start)
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row() {
                    OutlinedTextField(
                        value = "",
                        onValueChange = { },
                        placeholder = { Text("", color = Color.Gray) },
                        leadingIcon = {
                            Icon(
                                imageVector = Icons.Outlined.Search,
                                contentDescription = "Buscar",
                                tint = colorResource(R.color.cafe_oscuro_principal)
                            )
                        },
                        shape = CircleShape,
                        singleLine = true,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(52.dp)
                            .padding(horizontal = 16.dp)
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text =  stringResource(R.string.categorias),
                    fontFamily = PoppinsFontFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.Start)
                )


                    Box(Modifier.padding(10.dp)) {
                        when(uiStateC) {
                            CategoriaUiState.Loading -> CircularProgressIndicator(
                                Modifier.align(Alignment.Center),
                                color = MaterialTheme.colorScheme.tertiary
                            )
                            is CategoriaUiState.Error -> Column(Modifier
                                .align(Alignment.Center)
                                .padding(20.dp),
                                horizontalAlignment = Alignment.CenterHorizontally) {
                                Icon(Icons.Outlined.Error, contentDescription = null,
                                    modifier = Modifier.height(12.dp),
                                    tint = MaterialTheme.colorScheme.tertiary)
                                Text("No se pudieron cargar las categorias", style = MaterialTheme.typography.titleMedium)
                                FilledTonalButton(onClick = onReintentar) { Text("Reintentar") }
                            }
                            is CategoriaUiState.Success -> ListaCategorias(uiStateC.categorias)
                        }
                    }



                Box(Modifier
                    .fillMaxSize()
                    .padding(10.dp)) {
                    when(uiState) {
                        ProductoUiState.Loading -> CircularProgressIndicator(
                            Modifier.align(Alignment.Center),
                            color = MaterialTheme.colorScheme.tertiary
                        )
                        is ProductoUiState.Error -> Column(Modifier
                            .align(Alignment.Center)
                            .padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(Icons.Outlined.Business, contentDescription = null,
                                modifier = Modifier.fillMaxSize(),
                                tint = MaterialTheme.colorScheme.tertiary)
                            Text("No se pudieron cargar las oficinas", style = MaterialTheme.typography.titleMedium)
                            FilledTonalButton(onClick = onReintentar) { Text("Reintentar") }
                        }
                        is ProductoUiState.Success -> ListaProductos(uiState.productos)
                    }
                }









            }

        }

    }

}


@Composable
private fun ListaProductos(productos: List<Producto> ){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(productos, key = { it.idProducto }){ producto ->
            ItemProducto(producto , ondetalle =  {   })
        }
    }
}

@Composable
private fun ListaCategorias(categorias: List<Categoria>){

    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(categorias, key = { it.idCategoria }){ categoria ->
            itemCategoria(categoria)
        }
    }

}
