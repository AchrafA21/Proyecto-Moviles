package com.example.proyectomovilesactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.proyectomovilesactivity.database.dao.AppDatabase
import com.example.proyectomovilesactivity.databinding.ActivityPaginaN2Binding
import com.example.proyectomovilesactivity.databinding.ActivityRecyclerviewBinding

class RecyclerviewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerviewBinding
    private  lateinit var db:AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerviewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        db = Room.databaseBuilder(
            this, AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        )
            .allowMainThreadQueries().build()

        binding.recyclerView2.layoutManager =
            GridLayoutManager(this, 1, RecyclerView.VERTICAL, false)
        binding.recyclerView2.adapter = MovileAdapter(
            db.movileDao().list(),this,db

        )
        binding.volver3.setOnClickListener {
            val anadirmovileIntent = Intent(this, Pagina_n2::class.java)
            startActivity(anadirmovileIntent)
        }

    }

    override fun onResume() {
        super.onResume()
        val adapter = binding.recyclerView2.adapter as MovileAdapter
        adapter.moviles = db.movileDao().list()
        adapter.notifyDataSetChanged()
    }






}