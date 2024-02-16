package com.example.proyectomovilesactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.example.proyectomovilesactivity.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar2)



        }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.movile_contex_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId){
            R.id.anadirmovile->{
                val pagina_N2Intent = Intent(this, Pagina_n2::class.java)
                startActivity(pagina_N2Intent)
                true


            }
            R.id.anadircliente->{
                val pagina_N1Intent = Intent(this, Pagina_n1::class.java)
                startActivity(pagina_N1Intent)
                true

            }
            R.id.catalogoM->{
                val RecyclerviewActivityIntent= Intent(this, RecyclerviewActivity::class.java)
                startActivity(RecyclerviewActivityIntent)
                true

            }
            R.id.catalogoC->{
                val recyclerviewclienteIntent = Intent(this, RecyclerviewClienteActivity::class.java)
                startActivity(recyclerviewclienteIntent)
                true

            }


            else->{
                super.onOptionsItemSelected(item)
            }
        }

    }






}