package com.example.proyectomovilesactivity.database.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.proyectomovilesactivity.Modelo.Cliente
import com.example.proyectomovilesactivity.Modelo.Movile

@Database(entities = [Movile::class ,Cliente::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    companion object {
        val DATABASE_NAME = "Biblioteca"
    }
    abstract fun movileDao(): MovileDAO
    abstract fun clienteDao(): ClienteDao




}