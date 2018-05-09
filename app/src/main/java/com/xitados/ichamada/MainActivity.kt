package com.xitados.ichamada

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var context = this

        var db = DataBaseHandler(context)

        btn_login.setOnClickListener({
            if(etvName.text.toString().length >0 &&etvSenha.text.toString().length >0  ){

                var accept:Boolean = db.Autentica(etvName.text.toString(), etvSenha.text.toString())

                if (accept == true){
                    Toast.makeText(context,"Login feito com Sucesso",Toast.LENGTH_SHORT).show()
                    val id_prof = db.enviaProf(etvName.text.toString(),etvSenha.text.toString() )

                    val randomIntent = Intent(this, Logado::class.java)
                    startActivity(randomIntent)


                }else{
                    Toast.makeText(context,"Usuario ou senha incorreto",Toast.LENGTH_SHORT).show()
                }

            }else{
                Toast.makeText(context,"Preencha todos os campos",Toast.LENGTH_SHORT).show()

            }
        })





    }









}
