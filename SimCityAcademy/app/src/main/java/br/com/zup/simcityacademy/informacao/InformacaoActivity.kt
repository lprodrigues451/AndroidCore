package br.com.zup.simcityacademy.informacao

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import br.com.zup.simcityacademy.R
import br.com.zup.simcityacademy.databinding.ActivityInformacaoBinding

class InformacaoActivity : AppCompatActivity() {
    private lateinit var binding : ActivityInformacaoBinding
    //TODO lógica para vincular as view, recuperar e exibir os dados

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformacaoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.titulo_informacoes)

        recuperarDadosAlune()
    }

    @SuppressLint("SetTextI18n")
    private fun recuperarDadosAlune(){
        val nomeAlune = intent.extras?.get("NOME_ALUNE")?.toString()
        val notaUm = intent.extras?.get("NOTA_UM").toString().toDouble()
        val notaDois = intent.extras?.get("NOTA_DOIS").toString().toDouble()
        val notaTres = intent.extras?.get("NOTA_TRES").toString().toDouble()
        val notaQuatro = intent.extras?.get("NOTA_QUATRO").toString().toDouble()

        val mediaAluno = (notaUm + notaDois + notaTres + notaQuatro) / 4.0

        val situacao : String = if (mediaAluno < 7.0)
            "Reprovado"
        else
            "Aprovado"

        binding.tvMediaAlune.text = "A sua média foi $mediaAluno"
        binding.tvNomeAlune.text = nomeAlune
        binding.MediaAprovadouOuReprovado.text = "$nomeAlune foi $situacao"
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}