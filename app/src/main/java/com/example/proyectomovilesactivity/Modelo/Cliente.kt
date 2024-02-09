package com.example.proyectomovilesactivity.Modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "cliente")
data class Cliente(
    @PrimaryKey val nombre: String,
    @ColumnInfo("appe")   val apellido: String,
    @ColumnInfo("telef")    val telefono: String

)
