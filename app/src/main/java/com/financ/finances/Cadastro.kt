package com.financ.finances

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.financ.finances.databinding.ActivityTelaDeCadastroBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class Cadastro : AppCompatActivity() {
    private lateinit var binding: ActivityTelaDeCadastroBinding
    private val auth=FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTelaDeCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textButao.setOnClickListener {it
            val email =binding.emailText.text.toString()
            val senha =binding.textSenha.text.toString()
             if(email.isEmpty() || senha.isEmpty()){
               val snackba = Snackbar.make(it,"Preencha os campos",Snackbar.LENGTH_SHORT)
                 snackba.setBackgroundTint(Color.RED)
                 snackba.show()
             }else{
               auth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener { cadastro ->
                   if (cadastro.isSuccessful){
                       val snackbar = Snackbar.make(it,"Cadastrado com sucesso!",Snackbar.LENGTH_SHORT)
                       snackbar.setBackgroundTint(Color.GREEN)
                       snackbar.show()
                       binding.emailText.setText("")
                       binding.textSenha.setText("")
                   }
               }.addOnFailureListener {exception ->
                val messagemError = when(exception){
                    is FirebaseAuthWeakPasswordException -> "Digite uma senha com minímo 6 caracteres!"
                    is FirebaseAuthInvalidCredentialsException -> "Digite um email válido!"
                    is FirebaseAuthUserCollisionException -> "Está conta já foi cadastrada!"
                    is FirebaseNetworkException -> "Sem conexão com internet!"
                    else -> "Error ao cadastrar usuário!"
                }
                   val snackbar = Snackbar.make(it,messagemError,Snackbar.LENGTH_SHORT)
                   snackbar.setBackgroundTint(Color.RED)
                   snackbar.show()
               }
             }

        }
    }
}