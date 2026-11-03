package com.example.proyectocafe.screen.productos

import com.example.proyectocafe.models.Producto

sealed interface ProductoUiState {
    data object Loading: ProductoUiState
    data class Success(val productos: List<Producto>): ProductoUiState
    data class Error(val mensaje: String): ProductoUiState
}