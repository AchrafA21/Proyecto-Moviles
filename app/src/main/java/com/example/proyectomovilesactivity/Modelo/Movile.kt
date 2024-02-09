package com.example.proyectomovilesactivity.Modelo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movile")
data class Movile(
    @PrimaryKey val modelo: String,
    @ColumnInfo("espacio")   val espacio: String,
    @ColumnInfo("salud")    val salud: String
)

