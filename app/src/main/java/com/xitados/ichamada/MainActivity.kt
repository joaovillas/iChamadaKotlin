package com.xitados.ichamada

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
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

                var professor = Professor(etvName.text.toString(),etvSenha.text.toString() )
                //var turmas = Turmas()
                professor.nome = etvName.text.toString()
                professor.password = etvSenha.text.toString()

                db.insertData   (professor)

            }else{
                Toast.makeText(context,"Preencha todos os campos",Toast.LENGTH_SHORT).show()

            }
        })

        btn_read.setOnClickListener({
            var data = db.readDataAlunos()
            print(data)
            tvResult.text ="Lista de Alunos\n"

            for (i in 0..data.size-1){

                //println(data.get(i).id_turma.toString())
                //println(data.get(i).disciplina.toString())



                tvResult.append(data.get(i).fk_turmas.toString() +"   "+data.get(i).qtd_faltas.toString()+"    "+data.get(i).nome.toString()+"\n")
            }

        })




    }









}
