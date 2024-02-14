package com.example.proyectomovilesactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.proyectomovilesactivity.Modelo.Cliente
import com.example.proyectomovilesactivity.database.dao.AppDatabase
import com.example.proyectomovilesactivity.databinding.ActivityRecyclerviewBinding
import com.example.proyectomovilesactivity.databinding.ActivityRecyclerviewClienteBinding

class RecyclerviewClienteActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerviewClienteBinding
    private  lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerviewClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = Room.databaseBuilder(
            this, AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
            .allowMainThreadQueries().build()

        binding.recyclerView.layoutManager =
            GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)
        binding.recyclerView.adapter = ClienteAdapter(
            db.clienteDao().list(),this,db

        )

        binding.volver.setOnClickListener {
            val anadirclienteIntent = Intent(this, Pagina_n1::class.java)
            startActivity(anadirclienteIntent)
        }
        binding.volverMenu.setOnClickListener {
            val irMenuPrincipalIntent = Intent(this, MainActivity::class.java)
            startActivity(irMenuPrincipalIntent)
        }


    }
    override fun onResume() {
        super.onResume()
        val adapter = binding.recyclerView.adapter as ClienteAdapter
        adapter.clientes = db.clienteDao().list()
        adapter.notifyDataSetChanged()
    }


}