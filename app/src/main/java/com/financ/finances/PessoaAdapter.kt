package com.financ.finances

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 *  Essa classe é de adapter para lista um layout varias vezes com seus itens
 *
 */
class PessoaAdapter (var listaPessoa: ArrayList<Pessoa>) : RecyclerView.Adapter<PessoaAdapter.PessoaViewHolder>() {

    class PessoaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
       // variável do campo de texto do layout
        var text:TextView=itemView.findViewById(R.id.dados)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PessoaViewHolder {
      //Pegando a view que vai se exibido no recycleview
        var view=LayoutInflater.from(parent
            .context).inflate(R.layout.listapessoa,parent,false)
        return PessoaViewHolder(view)
    }
    override fun getItemCount(): Int {
        //Passano o tamanho da lista dos itens
        return listaPessoa.size
    }
    override fun onBindViewHolder(holder: PessoaViewHolder, position: Int) {
        //PEGANDO A POSIÇÃO DO ITEM
        var Pessoa =listaPessoa[position]
        //EXIBINDO O TEXTO NO LAYOUT
        holder.text.setText(Pessoa.idade)

    }
}