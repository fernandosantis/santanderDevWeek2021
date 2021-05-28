package com.example.santanderdevweek.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santanderdevweek.R
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        val doubleReal = DecimalFormat("R$ #,##0.00")

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        mainViewModel.buscarConta().observe(
            this,
            Observer { result ->
                findViewById<TextView>(R.id.tv_agencia).text = getString(R.string.abr_agencia) + " " + result.agencia
                findViewById<TextView>(R.id.tv_numero_conta).text = getString(R.string.abr_conta) + " " + result.numero_conta
                findViewById<TextView>(R.id.tv_nome_cliente).text = getString(R.string.saudacao) + ", " + result.cliente.nome
                findViewById<TextView>(R.id.tv_saldo).text = doubleReal.format(result.saldo)
                findViewById<TextView>(R.id.tv_saldo_limite).text = doubleReal.format(result.saldo + result.limite)
                val numCartao = (result.cartao.numero).toString()
                val finalCartao = numCartao.substring(numCartao.length - 4)
                findViewById<TextView>(R.id.tv_final_cartao).text = finalCartao
            }
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_notification -> {
                Log.d("CLICK", "Clique no item 1")
                true
            }
            else -> {
                super.onOptionsItemSelected(item)
            }
        }
    }
}
