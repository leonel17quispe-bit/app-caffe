package com.example.proyectocafe.data.remote

import com.example.proyectocafe.models.User
import retrofit2.http.GET

interface UserService {
    @GET("usuarios.php")
    suspend fun getUser() : List<User>
}