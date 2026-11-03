package com.example.proyectocafe.data.remote

import com.example.proyectocafe.models.Categoria
import retrofit2.http.GET

interface CategoriaService {
    @GET("categorias.php")
    suspend fun getCategorias() : List<Categoria>
}