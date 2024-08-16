package com.financ.finances

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.financ.finances.databinding.ActivityMainBinding
import com.google.firebase.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding  // usando viewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)  // objeto do tipo binding
        setContentView(binding.root) // seta a view
        binding.recycleviewPesssoa.layoutManager=LinearLayoutManager(this) // configurando o recycleview
        var gente=Processo()  // criado um objeto
        binding.recycleviewPesssoa.adapter=PessoaAdapter(gente.listaPessoas)  // Passando o objeto para o adapter
     Firebase
    }
}