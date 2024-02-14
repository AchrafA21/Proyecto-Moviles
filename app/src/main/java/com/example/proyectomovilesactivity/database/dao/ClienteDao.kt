package com.example.proyectomovilesactivity.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.proyectomovilesactivity.Modelo.Cliente
@Dao
interface ClienteDao {
    @Query("SELECT * FROM cliente")
    fun list(): List<Cliente>

    @Query("DELETE FROM cliente WHERE nombre=:nombre")
    fun delete(nombre: String): Int

    @Query("SELECT * FROM cliente WHERE nombre=:nombre")
    fun listCliente(nombre: String): List<Cliente>


    @Insert
    fun save(cliente: Cliente)
}