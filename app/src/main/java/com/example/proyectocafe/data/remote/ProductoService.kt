package com.example.proyectocafe.data.remote

import com.example.proyectocafe.models.Producto
import retrofit2.http.GET

interface ProductoService {
    @GET("productos.php")
    suspend fun getProductos() : List<Producto>
}