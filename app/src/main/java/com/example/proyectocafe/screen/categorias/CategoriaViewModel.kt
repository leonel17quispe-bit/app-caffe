package com.example.proyectocafe.screen.categorias

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectocafe.data.repository.CategoriaRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CategoriaViewModel (
    private val repository: CategoriaRepository = CategoriaRepository()
): ViewModel() {
    private val _uiState = MutableStateFlow<CategoriaUiState>(CategoriaUiState.Loading)
    val uiStateC: StateFlow<CategoriaUiState> = _uiState.asStateFlow()

    fun fetchCategorias() {
        viewModelScope.launch {
            _uiState.value = CategoriaUiState.Loading
            _uiState.value = try {
                CategoriaUiState.Success(repository.listCategorias())
            } catch (e: CancellationException) {
                throw e
            } catch (e: Exception) {
                CategoriaUiState.Error(
                    "No se pudieron cargar los datos. Revise su conexión o intente de nuevo: "
                            + e.message
                )
            }
        }
    }

    init {
        fetchCategorias()
    }
}