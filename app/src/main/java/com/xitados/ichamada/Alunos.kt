package com.xitados.ichamada

/**
 * Created by Joao Pedro on 07/05/2018.
 */


class Alunos {

    var id_aluno:Int = 1
    var nome:String = ""
    var qtd_faltas:Int = 0
    var fk_turmas:Int = 1

    constructor( id_aluno:Int, nome:String , qtd_faltas:Int , fk_turmas:Int){

        this.id_aluno = id_aluno
        this.nome= nome
        this.qtd_faltas = qtd_faltas
        this.fk_turmas = fk_turmas

    }

    constructor(){

    }




}