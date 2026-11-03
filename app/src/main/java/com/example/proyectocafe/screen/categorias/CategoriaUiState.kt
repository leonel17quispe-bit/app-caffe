package com.example.proyectocafe.screen.categorias

import com.example.proyectocafe.models.Categoria

sealed interface CategoriaUiState {
    data object Loading: CategoriaUiState
    data class Success(val categorias: List<Categoria>): CategoriaUiState
    data class Error(val mensaje: String): CategoriaUiState
}