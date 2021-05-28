package com.example.santanderdevweek.data

data class Conta(
    val agencia: String,
    val numero_conta: String,
    val saldo: Double,
    val limite: Double,
    val cliente: Cliente,
    val cartao: Cartao
)
