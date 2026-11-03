package com.example.proyectocafe.models

data class Producto(
    val idProducto: Int = 0,
    val nombre : String ="",
    val descripcion : String ="",
    val categoria : String ="",
    val precio : Double=0.0,
    val stock : Int = 0,
    val estado : Int=0,
)