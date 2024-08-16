package com.financ.finances

class Processo {
    var listaPessoas= ArrayList<Pessoa>()

    init {
        for (i in 0..100){
        listaPessoas.add(Pessoa(i,i.toString()))
        }
    }
}