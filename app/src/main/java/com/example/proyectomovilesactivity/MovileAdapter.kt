package com.example.proyectomovilesactivity

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomovilesactivity.Modelo.Movile
import com.example.proyectomovilesactivity.database.dao.AppDatabase
import com.example.proyectomovilesactivity.databinding.ActivityMovileBinding
import com.example.proyectomovilesactivity.databinding.MovileLayoutBinding

class MovileAdapter (
    var moviles: List<Movile>,
    val context: Context,
    val db: AppDatabase
) :
    RecyclerView.Adapter<MovileAdapter.ItemViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            layoutInflater.inflate(R.layout.activity_movile, null)
        )
    }

    override fun getItemCount(): Int {
        return moviles.size
    }






  override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val Movile = moviles[position]
        val binding = ActivityMovileBinding.bind(holder.itemView)

        binding.modelText.text = Movile.modelo


        binding.almaTextView.text = Movile.espacio

        binding.saludTextview.text = Movile.salud


        binding.deleteMovileButton.setOnClickListener{
            val deletedRows = db.movileDao().delete(Movile.modelo)

            moviles = db.movileDao().list()

            notifyDataSetChanged()
            if(deletedRows == 0) {
                Toast.makeText(context, "No se ha eliminado ningún Movil", Toast.LENGTH_LONG).show()
            }
        }


      binding.editMovileButton.setOnClickListener{
          val deletedRows = db.movileDao().delete(Movile.modelo)

          moviles = db.movileDao().list()

          notifyDataSetChanged()
          if(deletedRows == 0) {
              Toast.makeText(context, "No se ha eliminado ningún Movil", Toast.LENGTH_LONG).show()
          }
      }


    }


    }
