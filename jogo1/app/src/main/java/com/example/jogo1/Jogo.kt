package com.example.jogo1

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class Jogo: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jogo)

        // Referenciando as ImageViews
        val pedra = findViewById<ImageView>(R.id.Pedra)
        val papel = findViewById<ImageView>(R.id.Papel)
        val tesoura = findViewById<ImageView>(R.id.Tesoura)

        // Adicionando os listeners para cada opção
        pedra.setOnClickListener { playGame("Pedra") }
        papel.setOnClickListener { playGame("Papel") }
        tesoura.setOnClickListener { playGame("Tesoura") }
    }
    // Função sobre início do jogo
    private fun playGame(playerChoice: String) {
        val computerChoice = getComputerChoice()
        val result = determineWinner(playerChoice, computerChoice)

        // Exibe as escolhas e o resultado do jogo
        Toast.makeText(this, "Você escolheu: $playerChoice\nComputador escolheu: $computerChoice\n$result", Toast.LENGTH_SHORT).show()
    }

    // Função que gera uma escolha aleatória para o computador
    private fun getComputerChoice(): String {
        // Lista de opções possíveis
        val choices = listOf("Pedra", "Papel", "Tesoura")
        // Retorna uma escolha aleatória
        return choices[Random.nextInt(choices.size)]
    }
    // Função que determina o vencedor do jogo
    private fun determineWinner(playerChoice: String, computerChoice: String): String {
        return when {
            playerChoice == computerChoice -> "Empate!"
            playerChoice == "Pedra" && computerChoice == "Tesoura" -> "Você venceu!"
            playerChoice == "Papel" && computerChoice == "Pedra" -> "Você venceu!"
            playerChoice == "Tesoura" && computerChoice == "Papel" -> "Você venceu!"
            else -> "Você perdeu!"
        }
    }
}