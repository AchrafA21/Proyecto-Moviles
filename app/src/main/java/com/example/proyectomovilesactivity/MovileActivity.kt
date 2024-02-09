package com.example.proyectomovilesactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.proyectomovilesactivity.databinding.ActivityMainBinding
import com.example.proyectomovilesactivity.databinding.ActivityMovileBinding

class MovileActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMovileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMovileBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}