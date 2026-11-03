package com.example.proyectocafe.data.repository

import com.example.proyectocafe.data.remote.CategoriaService
import com.example.proyectocafe.data.remote.RetrofitClient
import com.example.proyectocafe.models.Categoria

class CategoriaRepository (
    private val service : CategoriaService = RetrofitClient.categoriaService
){
    suspend fun listCategorias() : List<Categoria> = service.getCategorias()
}