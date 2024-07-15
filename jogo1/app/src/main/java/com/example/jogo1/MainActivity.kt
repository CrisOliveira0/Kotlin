package com.example.jogo1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.jogo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        //referência ao botão
        val Inicio: Button = findViewById(R.id.Inicio)

        //Quando pressionado o respectivo botão inicia a atividade designada
            binding.Inicio.setOnClickListener {
            val intent = Intent (this, Jogo::class.java)
           startActivity(intent)
        }
    }

}
