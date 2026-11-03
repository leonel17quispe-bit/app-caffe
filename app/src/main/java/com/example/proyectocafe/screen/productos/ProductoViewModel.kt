package com.example.proyectocafe.screen.productos

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectocafe.data.repository.ProductoRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductoViewModel (
    private val repository: ProductoRepository = ProductoRepository()
): ViewModel()
{
    private val _uiState = MutableStateFlow< ProductoUiState>(ProductoUiState.Loading)
    val uiState: StateFlow<ProductoUiState> = _uiState.asStateFlow()

    fun fetchCategoria(){
        viewModelScope.launch {
            _uiState.value = ProductoUiState.Loading
            _uiState.value = try {
                ProductoUiState.Success(repository.listProductos())
            } catch (e: CancellationException){
                throw e
            } catch (e: Exception){
                ProductoUiState.Error(
                    "No se pudieron cargar los datos. Revise su conexión o intente de nuevo: "
                            + e.message)
            }
        }
    }
    init {
        fetchCategoria()
    }
}