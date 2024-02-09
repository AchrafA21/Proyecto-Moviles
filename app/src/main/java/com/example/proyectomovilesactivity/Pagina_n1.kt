package com.example.proyectomovilesactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
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

        binding.guardar1.setOnClickListener {

            val isbn = binding.nombre.text.toString()
            val title = binding.appellido.text.toString()
            val author = binding.telefono.text.toString()



            db = Room
                .databaseBuilder(
                    this,
                    AppDatabase::class.java,
                    AppDatabase.DATABASE_NAME
                )
                .allowMainThreadQueries().build()





            Toast.makeText(this, "Cliente agregado con exito", Toast.LENGTH_SHORT)
                .show()



            val recyclerviewclienteIntent = Intent(this, RecyclerviewClienteActivity::class.java)
            startActivity(recyclerviewclienteIntent)

        }
    }
}