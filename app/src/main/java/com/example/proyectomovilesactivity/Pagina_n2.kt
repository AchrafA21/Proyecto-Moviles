package com.example.proyectomovilesactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.proyectomovilesactivity.Modelo.Movile
import com.example.proyectomovilesactivity.database.dao.AppDatabase
import com.example.proyectomovilesactivity.database.dao.MovileDAO
import com.example.proyectomovilesactivity.databinding.ActivityPaginaN1Binding
import com.example.proyectomovilesactivity.databinding.ActivityPaginaN2Binding

class Pagina_n2 : AppCompatActivity() {
    private lateinit var binding: ActivityPaginaN2Binding
    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaN2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()

        binding.Save.setOnClickListener {
            val modelo = binding.model.text.toString()
            val almacenamiento = binding.almac.text.toString()
            val saludbateria = binding.salud.text.toString()

            // Verificar si algún campo está vacío
            if (modelo.isEmpty() || almacenamiento.isEmpty() || saludbateria.isEmpty()) {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val movil = Movile(
                    modelo = modelo,
                    espacio = almacenamiento,
                    salud = saludbateria
                )

                db.movileDao().save(movil)

                Toast.makeText(this, "Móvil agregado con éxito", Toast.LENGTH_SHORT).show()

                val recyclerviewActivityIntent = Intent(this, RecyclerviewActivity::class.java)
                startActivity(recyclerviewActivityIntent)
            }
        }

    }
}