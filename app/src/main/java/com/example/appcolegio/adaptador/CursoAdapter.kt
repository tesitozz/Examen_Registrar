package com.example.appcolegio.adaptador

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appcolegio.R
import com.example.appcolegio.entidad.Curso

class CursoAdapter(var lista:ArrayList<Curso>):RecyclerView.Adapter<ViewCurso>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewCurso {
        var info = LayoutInflater.from(parent.context).inflate(R.layout.item_curso,parent,false)
        return ViewCurso(info)
    }

    override fun getItemCount(): Int {
        //Retornar la cantidad de objetos que existan el arreglo "lista"
        return lista.size
    }

    override fun onBindViewHolder(holder: ViewCurso, position: Int) {

        //Mostrar los valores
        holder.tvCodigo.setText(lista.get(position).codigo.toString())
        holder.tvNombreCurso.setText(lista.get(position).nombreCurso)

    }


}