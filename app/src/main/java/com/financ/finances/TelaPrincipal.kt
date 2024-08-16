package com.financ.finances

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.financ.finances.databinding.ActivityTelaPrincipalBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class TelaPrincipal : AppCompatActivity() {
    private lateinit var binding: ActivityTelaPrincipalBinding
    private val db=FirebaseFirestore.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityTelaPrincipalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.botaoDeslogar.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            val irTelaLogin=Intent(this,TelaLogin::class.java)
            startActivity(irTelaLogin)
        }

        binding.botaoSalvar.setOnClickListener {
            val usaurioMap= hashMapOf(
                "Nome" to "Anderson",
                "Sobre Nome" to "Fernandes"
            )
            db.collection("Usuários").document("Anderson").set(usaurioMap).addOnCompleteListener {
                Log.i("tect","sucesso!")
            }.addOnFailureListener {
                Log.i("tect","Falhou ao gravar")
            }
        }

        binding.botaoLer.setOnClickListener {
            db.collection("Usuários").document("Anderson")
                .addSnapshotListener { value, error ->
                    if (value !=null){
                        Log.i("tect","nome: "+value.getString("Nome"))
                        Log.i("tect","Sobre nome: "+value.getString("Sobre Nome"))
                    }
                }
        }
        binding.botaoAltera.setOnClickListener {
            db.collection("Usuários").document("Anderson")
                .update("Sobre Nome","Fonseca").addOnCompleteListener {
                    Log.i("tect","altera do com sucesso!")
                }
        }

        binding.botaoDeletar.setOnClickListener {
            db.collection("Usuários").document("Anderson")
                .delete().addOnCompleteListener {
                    Log.i("tect","deletado com sucesso!")
                }
        }

    }
}