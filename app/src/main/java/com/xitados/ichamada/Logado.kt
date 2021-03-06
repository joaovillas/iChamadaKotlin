package com.xitados.ichamada

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class Logado : AppCompatActivity() {

    private lateinit var listView:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_logged)



        listView = findViewById<ListView>(R.id.recipe_list_view)

        var db = DataBaseHandler(this)

        var recipeList = db.readDataTurmas()



        val listItems = arrayOfNulls<String>(recipeList.size)

        for (i in 0 until recipeList.size) {
            val recipe = recipeList[i]
            listItems[i] = recipe.disciplina + " \n" +recipe.horario
            Log.d("Lista",listItems[i])
        }

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
        listView.adapter = adapter

        listView.setOnItemClickListener( {adapterView, view, i, l ->

            val randomIntent = Intent(this, SalaAula::class.java)
            startActivity(randomIntent)

        })



    }

    }










