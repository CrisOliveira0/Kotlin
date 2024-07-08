package gcc.holywater.jogodavelha

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.jogodavelha.R
import com.example.jogodavelha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
        private lateinit var binding: ActivityMainBinding

        //matriz que representa cada espaço do jogo para marcar
        val tabuleiro = arrayOf(
            arrayOf("A", "B", "C"),
            arrayOf("D", "E", "F"),
            arrayOf("G", "H", "I")
        )

        //declaração do primero jogador
        var jogadorAtual = "o"

        //função que roda tudo no código
        override fun onCreate(savedInstanceState: Bundle?) {
            binding = ActivityMainBinding.inflate(layoutInflater)
            super.onCreate(savedInstanceState)
            setContentView(binding.root)
        }

        //função do jogadorAtual
        fun buttonClick(view: View) {

            //esse é a representação do jogador
            val buttonSelecionado = view as Button

            //declaração do jogador que joga no momento
            buttonSelecionado.text = jogadorAtual

            //usa o id do botão selecionado, para declarar o jogador que joga
            when (buttonSelecionado.id) {
                binding.buttonUm.id -> tabuleiro[0][0] = jogadorAtual
                binding.buttonDois.id -> tabuleiro[0][1] = jogadorAtual
                binding.buttonTres.id -> tabuleiro[0][2] = jogadorAtual
                binding.buttonQuatro.id -> tabuleiro[1][0] = jogadorAtual
                binding.buttonCinco.id -> tabuleiro[1][1] = jogadorAtual
                binding.buttonSeis.id -> tabuleiro[1][2] = jogadorAtual
                binding.buttonSete.id -> tabuleiro[2][0] = jogadorAtual
                binding.buttonOito.id -> tabuleiro[1][1] = jogadorAtual
                binding.buttonNove.id -> tabuleiro[2][2] = jogadorAtual
            }

            var vencedor = verificaVencedor(tabuleiro)

            if (!vencedor.isNullOrBlank()) {
                Toast.makeText(this, "Vencedor: " + vencedor, Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MainActivity::class.java)
            }

            //declara qual jogador joga
            if (jogadorAtual.equals("X")) {
                //Se o primeiro jogador for "X", então o fundo fica verde e o jogador é definido como "O"
                buttonSelecionado.setBackgroundResource(R.drawable.lubu)
                jogadorAtual = "O"
            } else {
                //Senão o jogador "O" terá o fundo vermelho definido como "X", e vise-versa
                buttonSelecionado.setBackgroundResource(R.drawable.thor)
                jogadorAtual = "X"
            }
            buttonSelecionado.isEnabled = false
        }

        //funçao para verificação do vencedor
        fun verificaVencedor(tabuleiro: Array<Array<String>>): String? {
            //verificação as linhas e colunas
            for (i in 0 until 3) {
                //verifica os itens iguais na linha
                if (tabuleiro[i][0] == tabuleiro[i][1] && tabuleiro[i][1] == tabuleiro[i][2]) {
                    return tabuleiro[i][0]
                }
                //verifica os itens iguais na coluna
                if (tabuleiro[0][i] == tabuleiro[1][i] && tabuleiro[1][i] == tabuleiro[2][i]) {
                    return tabuleiro[0][i]
                }
            }

            return null
        }
    }

