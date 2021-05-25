package com.example.santanderdevweek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Condicionais
        var idade = 20

        val minhaIdade = if(idade > 18) {
            "Maior de Idade"
            } else{
                "Menor de Idade"
            }

        val idadeMaior = when {
            idade > 18 -> "Maior"
            else -> "Menor"
        }

        fun idadeMinha () : String {
            return "46 Anos"
        }

        println("Idade: " + idade)
        println("Minha Idade: " +minhaIdade)
        println("Idade Maior: " +idadeMaior)
        println(idadeMinha())

        val medicamento = Medicamento("Remedio1","2x ao dia")


        setContentView(R.layout.activity_main)
    }
}