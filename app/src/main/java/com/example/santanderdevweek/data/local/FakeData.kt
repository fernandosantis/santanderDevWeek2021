package com.example.santanderdevweek.data.local

import com.example.santanderdevweek.data.Cartao
import com.example.santanderdevweek.data.Cliente
import com.example.santanderdevweek.data.Conta

class FakeData {
    fun getDadosConta(): Conta {
        val cliente = Cliente("Fernando")
        val cartao = Cartao("0456892387654588")
        return Conta(
            "0304",
            "010012345-0",
            1845.15,
            800.00,
            cliente,
            cartao
        )
    }
}
