package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import java.io.IOException

class MainActivity : AppCompatActivity() {
    val listaAmigos = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun guardarValor(view: View){
        val listView = findViewById<ListView>(R.id.lista_de_amigos)
        listaAmigos.add(ingresaValor.text.toString())
        listView.adapter = Adaptador(this,listaAmigos)
    }


    class Adaptador(context: Context,lista: List<String>) : BaseAdapter() {
        private var mContext = context
        private var listaAmigos = lista

        init{
            listaAmigos = listaAmigos
            mContext = context
        }

        override fun getItem(position: Int): Any {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
        override fun getCount(): Int {
            return listaAmigos.size
        }
        override fun getItemId(position: Int): Long {
            return position.toLong()
        }
        @SuppressLint("ViewHolder")
        override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
            val layoutInflater = LayoutInflater.from(mContext)
            val rowMain = layoutInflater.inflate(R.layout.main_row, viewGroup, false)

            val nameTextView = rowMain.findViewById<TextView>(R.id.nombre_textView)
            nameTextView.text = " - " +listaAmigos.get(position)

            return rowMain

        }
    }



    }

