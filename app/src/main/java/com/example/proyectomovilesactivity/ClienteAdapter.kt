package com.example.proyectomovilesactivity

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.proyectomovilesactivity.Modelo.Cliente
import com.example.proyectomovilesactivity.database.dao.AppDatabase
import com.example.proyectomovilesactivity.databinding.ActivityClienteBinding


class ClienteAdapter (
    var clientes: List<Cliente>,
    val context: Context,
    val db: AppDatabase
) :
    RecyclerView.Adapter<ClienteAdapter.ItemViewHolder>() {

    private val layoutInflater = LayoutInflater.from(context)

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            layoutInflater.inflate(R.layout.activity_cliente, null)
        )
    }

    override fun getItemCount(): Int {
        return clientes.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val Cliente = clientes[position]
        val binding = ActivityClienteBinding.bind(holder.itemView)

        binding.nameText.text = Cliente.nombre


        binding.appeText.text = Cliente.apellido

        binding.telefText.text = Cliente.telefono


        binding.deleteCliente.setOnClickListener {
            val deletedRows = db.clienteDao().delete(Cliente.nombre)

            clientes = db.clienteDao().list()

            notifyDataSetChanged()
            if (deletedRows == 0) {
                Toast.makeText(context, "se ha eliminado el Cliente", Toast.LENGTH_LONG).show()
            }
        }


        binding.editCliente.setOnClickListener {
            val paginaN1Intent = Intent(context, Pagina_n1::class.java)
            context.startActivity(paginaN1Intent)
        }


    }
}