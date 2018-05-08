package com.xitados.ichamada

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast




    class DataBaseHandler  (var context:Context ):SQLiteOpenHelper(context,"iChamda.db",null,1){

        override fun onCreate(db: SQLiteDatabase?) {

        db?.execSQL("create table Professores(" +
                "id_prof integer not null primary key autoincrement," +
                "usuario varchar(255) not null ," +
                "senha varchar (255) not null " +
                ");" )

               db?.execSQL( "create table Turmas (" +
                "id_turma integer not null primary key," +
                "disciplina varchar(255) not null, " +
                "horario varchar(255) not null ," +
                "prof_key integer ," +
                "FOREIGN KEY(prof_key) REFERENCES Professor(id_prof)" +
                ");" )

                db?.execSQL("create table Alunos (" +
                "id_aluno integer not null primary key autoincrement," +
                "nome varchar(255) not null," +
                "qtd_faltas int  ," +
                "fk_turma integer ," +
                "FOREIGN KEY (fk_turma) References Turmas (id_turma)" +
                ");" )

                db?.execSQL("insert into Professores (usuario,senha) values ('admin','admin') , ('othon ' , '1234') ; insert into Turmas (id_turma , disciplina , horario , prof_key) values " +
                        "                    (1,'Orientação a Objetos' , '7:15', 2) , (2,'Programação para dispositivos moveis','10:05', 2 ) " +
                        "                    (3,'Banco de Dados', '7:15' , 2), (4,'Inteligencia Artificial' ,'10:05' ,2) , (5,'Interface Homem Computador' ,'7:15',2);" )


                 db?.execSQL("insert into Alunos (nome , qtd_faltas , fk_turma ) values ('Leonardo', 0, 2), ('Joao', 0, 2), ('Cesar', 0, 2), ('Victor', 10, 2), ('Benilton1', 15, 2), ('Julia', 1, 1), ('Maria', 7, 1), ('Pedro', 20, 3), ('Cralos', 10, 3), ('Paulo', 0, 2), ('Ana', 0, 3), ('Beatriz', 0, 2), ('Jamile', 0, 2), ('Natalia', 0, 1), ('Maitê', 0, 2), ('Claudia', 8, 2), ('Marcos', 0, 1), ('Cleide', 0, 1), ('Sandra', 5, 1), ('Paulo', 0, 1), ('Nanda', 6, 1), ('Thiago', 23, 1),  ('Marcos', 12, 1),  ('Paulo', 0, 3),  ('Crala', 0, 3),  ('Juan', 0, 3), ('Jonatan', 0, 3), ('Carina', 0, 3), ('Bethania', 0, 3), ('Sabrina', 0, 3), ('Amélia', 0, 3), ('Minéia', 6, 3), ('Adriana', 0, 2), ('Martinália', 0, 2), ('Douglas', 0, 2), ('Tatiane', 0, 2), ('Juliana', 0, 1), ('Plínio', 0, 1);")
        }

        override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

    fun insertData(professor:Professor){
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put("usuario",professor.nome)
        cv.put("senha",professor.password)
        var result = db.insert("Professores",null,cv)
        if (result == -1.toLong())
            Toast.makeText(context , "Failed",Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context , "Success",Toast.LENGTH_SHORT).show()


    }


    fun readData():ArrayList<Turmas>{

        var list: ArrayList<Turmas> = ArrayList()

        val db = this.readableDatabase
        //val query = "Select usuario,senha from Professores"
        val query = "Select id_turma , disciplina , horario , prof_key from Turmas;"
        val result = db.rawQuery(query,null)
        if (result.moveToFirst()){
            do{


                //var professor = Professor()
                var turmas = Turmas()
                //professor.nome = result.getString(result.getColumnIndex("usuario"))
                //professor.password = result.getString(result.getColumnIndex("senha"))
                turmas.id_turma = result.getInt(result.getColumnIndex("id_turma"))
                turmas.disciplina = result.getString(result.getColumnIndex("disciplina"))
                turmas.horario = result.getString(result.getColumnIndex("horario"))
                turmas.prof_key = result.getInt(result.getColumnIndex("prof_key"))


                list.add(turmas)




            }while(result.moveToNext())
        }
        println(list)


        return list
    }

        fun gerarAlunos(db: SQLiteDatabase?) {



        }
        fun insertDataTurmas(turmas: Turmas){
            val db = this.writableDatabase
            var cv = ContentValues()
            cv.put("horario",turmas.horario)
            cv.put("id_turma",turmas.id_turma)
            cv.put ("disciplina",turmas.disciplina)
            cv.put("prof_key",turmas.prof_key)
            var result = db.insert("Turmas",null,cv)
            if (result == -1.toLong())
                Toast.makeText(context , "Failed",Toast.LENGTH_SHORT).show()
            else
                Toast.makeText(context , "Success",Toast.LENGTH_SHORT).show()


        }


        fun insertAlunos(alunos:Alunos){
            val db = this.writableDatabase
            var cv = ContentValues()



        }

      fun  readDataAlunos():ArrayList<Alunos>{

            var list: ArrayList<Alunos> = ArrayList()

            val db = this.readableDatabase
            //val query = "Select usuario,senha from Professores"
            val query = "Select id_aluno,nome,qtd_faltas,fk_turma from Alunos"
            val result = db.rawQuery(query,null)
            if (result.moveToFirst()){
                do{


                    //var professor = Professor()
                    var alunos = Alunos()

                    //professor.nome = result.getString(result.getColumnIndex("usuario"))
                    alunos.id_aluno= result.getInt(result.getColumnIndex("id_aluno"))
                    alunos.nome = result.getString(result.getColumnIndex("nome"))

                    alunos.qtd_faltas = result.getInt(result.getColumnIndex("qtd_faltas"))
                    alunos.fk_turmas = result.getInt(result.getColumnIndex("fk_turma"))



                    list.add(alunos)




                }while(result.moveToNext())
            }
            println(list)


            return list
        }



    }