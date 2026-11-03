package com.example.proyectocafe.data.repository

import com.example.proyectocafe.models.Producto
import com.example.proyectocafe.data.remote.ProductoService
import com.example.proyectocafe.data.remote.RetrofitClient

class ProductoRepository (
    private val service : ProductoService = RetrofitClient.productoService
){
    suspend fun listProductos() : List<Producto> = service.getProductos()
}