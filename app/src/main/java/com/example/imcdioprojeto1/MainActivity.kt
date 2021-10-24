package com.example.imcdioprojeto1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.imcdioprojeto1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonCalcular.setOnClickListener{calcularIMC()}
    }

    fun calcularIMC(){
        val campoAltura = binding.editTextAltura.text.toString()
        val campoPeso   = binding.editTextPeso.text.toString()
        val altura = campoAltura.toDoubleOrNull()
        val peso   = campoPeso.toDoubleOrNull()

        if(altura == null || peso == null){

            if(altura == null && peso != null){
                Toast.makeText(this,"Campo Altura esta vazio!!!",Toast.LENGTH_SHORT).show()
            }else if(peso == null && altura != null){
                Toast.makeText(this,"Campo Peso esta vazio!!!.",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Altura e Peso estão vazios!!!",Toast.LENGTH_SHORT).show()
            }
            return
        }
        
        var resultadoIMC = peso!! / (altura!! * altura)
        val formatResultado = format(resultadoIMC)

    }
}