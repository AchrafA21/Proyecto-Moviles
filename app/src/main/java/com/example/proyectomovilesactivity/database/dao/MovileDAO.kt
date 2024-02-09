package com.example.proyectomovilesactivity.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.proyectomovilesactivity.Modelo.Movile


@Dao
interface MovileDAO {
    @Query("SELECT * FROM movile")
    fun list(): List<Movile>

    @Query("DELETE FROM movile WHERE modelo=:modelo")
    fun delete(modelo: String): Int

    @Query("SELECT * FROM movile WHERE espacio=:espacio")
    fun listAuthorBooks(espacio: String): List<Movile>


    @Insert
    fun save(movile: Movile)
}