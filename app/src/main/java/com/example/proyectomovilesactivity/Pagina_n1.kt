package com.example.proyectomovilesactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import com.example.proyectomovilesactivity.Modelo.Cliente
import com.example.proyectomovilesactivity.Modelo.Movile
import com.example.proyectomovilesactivity.database.dao.AppDatabase
import com.example.proyectomovilesactivity.databinding.ActivityMainBinding
import com.example.proyectomovilesactivity.databinding.ActivityPaginaN1Binding

class Pagina_n1 : AppCompatActivity() {
    private lateinit var binding: ActivityPaginaN1Binding
    private lateinit var db: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPaginaN1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                AppDatabase.DATABASE_NAME
            )
            .allowMainThreadQueries().build()

        binding.guardar1.setOnClickListener {
            val name = binding.nombre.text.toString()
            val appe = binding.appellido.text.toString()
            val telef = binding.telefono.text.toString()

            // Verificar si algún campo está vacío
            if (name.isEmpty() || appe.isEmpty() || telef.isEmpty()) {
                Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                val cliente = Cliente(
                    nombre = name,
                    apellido = appe,
                    telefono = telef
                )

                db.clienteDao().save(cliente)

                Toast.makeText(this, "Cliente agregado con éxito", Toast.LENGTH_SHORT).show()

                val recyclerviewclienteIntent = Intent(this, RecyclerviewClienteActivity::class.java)
                startActivity(recyclerviewclienteIntent)
            }
        }

    }
}