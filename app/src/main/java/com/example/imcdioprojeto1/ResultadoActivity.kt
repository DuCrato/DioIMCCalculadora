package com.example.imcdioprojeto1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.text.DecimalFormat

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val btResetar: Button = findViewById(R.id.buttonResetar)

        exibirResultado()
        btResetar.setOnClickListener{telaMain()}

    }

    fun exibirResultado(){

        val dadoMain = this.intent.extras

        var altura = dadoMain?.getDouble("altura")
        var peso   = dadoMain?.getDouble("peso")

        var resultadoImc = peso!! / (altura!! * altura)
        val numero = DecimalFormat("#.00")
        var resultadoFinal = numero.format(resultadoImc)

        val mostrarResultado: TextView = findViewById(R.id.text_resultado_imc)
        val tipoDeGordura:    TextView = findViewById(R.id.text_tipo_corpo)

        mostrarResultado.text = (resultadoFinal.toString())

        if(resultadoImc < 18.6){
            tipoDeGordura.text = ("Magreza")
        }else if(resultadoImc < 25.0){
            tipoDeGordura.text = ("Normal")
        }else if(resultadoImc < 30.0){
            tipoDeGordura.text = ("Sobre Peso")
        }else{ tipoDeGordura.text = ("Obesidade")}
    }

    fun telaMain(){
        val intencao = Intent(this, MainActivity::class.java)
        startActivity(intencao)
    }
}