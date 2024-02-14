package com.example.proyectomovilesactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectomovilesactivity.databinding.ActivityClienteBinding
import com.example.proyectomovilesactivity.databinding.ActivityMovileBinding
import com.example.proyectomovilesactivity.databinding.ActivityRecyclerviewBinding

class ClienteActivity : AppCompatActivity() {
    private lateinit var binding:ActivityClienteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }
}