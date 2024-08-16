package com.financ.finances

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.financ.finances.databinding.ActivityTelaLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth

class TelaLogin : AppCompatActivity() {
    private lateinit var binding: ActivityTelaLoginBinding
    private val auth=FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTelaLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textButaoLogar.setOnClickListener {view->
            val email=binding.emailLogin.text.toString()
            val senha=binding.loginSenha.text.toString()
            if (email.isEmpty() || senha.isEmpty()){
                val snackbar =Snackbar.make(view,"Preencha os campos",Snackbar.LENGTH_SHORT)
                snackbar.setBackgroundTint(Color.RED)
                snackbar.show()
            }else{
                auth.signInWithEmailAndPassword(email,senha).addOnCompleteListener {autenticacao->
                    if (autenticacao.isSuccessful){
                   redirecionamentoTelaPrincipal()
                    }
                }.addOnFailureListener {error->
                    val snackbar =Snackbar.make(view,"Error ao fazer o login!",Snackbar.LENGTH_SHORT)
                    snackbar.setBackgroundTint(Color.RED)
                    snackbar.show()
                }
            }
        }

        binding.semContCadastrar.setOnClickListener {
            val intent =Intent(this,Cadastro::class.java)
            startActivity(intent)
        }
    }

    private fun redirecionamentoTelaPrincipal(){
        val intent =Intent(this,TelaPrincipal::class.java)
        startActivity(intent)
        finish()
    }
// Método que é executador ao inicia o app
    override fun onStart() {
        super.onStart()
        val usuarioAtual=FirebaseAuth.getInstance().currentUser
        if (usuarioAtual !=null){
            redirecionamentoTelaPrincipal()
        }
    }
}