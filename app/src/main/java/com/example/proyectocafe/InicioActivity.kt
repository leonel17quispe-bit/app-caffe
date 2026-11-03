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
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults.colors
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
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
import com.example.proyectocafe.components.CoffeeCarousel
import com.example.proyectocafe.components.CupfulCanvas
import com.example.proyectocafe.components.TarjetaCafeItem
import com.example.proyectocafe.components.fondo
import com.example.proyectocafe.models.Producto
import com.example.proyectocafe.screen.categorias.itemCategoria
import com.example.proyectocafe.screen.productos.ItemProducto
import com.example.proyectocafe.screen.productos.ItemProductoHome
import com.example.proyectocafe.screen.productos.ProductoUiState
import com.example.proyectocafe.screen.productos.ProductoViewModel
import com.example.proyectocafe.ui.theme.PacificoFontFamily
import com.example.proyectocafe.ui.theme.PoppinsFontFamily
import com.example.proyectocafe.ui.theme.ProyectoCafeTheme

class InicioActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[ProductoViewModel::class.java]
        enableEdgeToEdge()
        setContent {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            ProyectoCafeTheme {

                var selectedTab by remember { mutableIntStateOf(0)}
                    homeView(
                        uiState = uiState,
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
fun homeView(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit,
    uiState: ProductoUiState
) {
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
            // Imagen de fondo con marca de agua
            fondo(
                painterResource(R.drawable.fondo_marca_agua),
                "",
                ContentScale.Crop
            )

            // Usamos rememberScrollState() para que toda la pantalla se pueda deslizar
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .navigationBarsPadding()
                    .padding(top = 35.dp, start = 10.dp, end = 10.dp, bottom = 20.dp),
                verticalArrangement = Arrangement.Top, // Cambiado a Top para que fluya correctamente
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CupfulCanvas()

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Good Morning",
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                    )
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Notifications,
                            contentDescription = "Notificacion",
                            tint = colorResource(R.color.cafe_oscuro_principal)
                        )
                    }
                }

                Spacer(modifier = Modifier.height(10.dp))

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

                Spacer(modifier = Modifier.height(10.dp))
                CoffeeCarousel()

                Spacer(modifier = Modifier.height(10.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Daily Special",
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Bold,
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Contenedor con altura controlada (ej. 220.dp) para evitar conflictos con el scroll general
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .padding(horizontal = 4.dp)
                ) {
                    when (uiState) {
                        ProductoUiState.Loading -> CircularProgressIndicator(
                            Modifier.align(Alignment.Center),
                            color = MaterialTheme.colorScheme.tertiary
                        )
                        is ProductoUiState.Error -> Column(
                            modifier = Modifier.align(Alignment.Center).padding(20.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Business,
                                contentDescription = null,
                                modifier = Modifier.size(48.dp), // Tamaño corregido para que no ocupe toda la pantalla
                                tint = MaterialTheme.colorScheme.tertiary
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Text("No se pudieron cargar los productos", style = MaterialTheme.typography.titleMedium)
                        }
                        is ProductoUiState.Success -> ListaProductos(uiState.productos)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Start
                ) {
                    Text(
                        text = "Customer Favorite",
                        fontFamily = PoppinsFontFamily,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

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


private val BARNER_URL =
    "https://alex273.alwaysdata.net/"





@Composable
private fun ListaProductos(productos: List<Producto>){
    LazyHorizontalGrid(
        rows = GridCells.Fixed(1),
        modifier = Modifier.fillMaxWidth()
            .height(225.dp),
        contentPadding = PaddingValues(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(productos, key = { it.idProducto }){ producto ->
            ItemProductoHome(producto)
        }
    }
}

