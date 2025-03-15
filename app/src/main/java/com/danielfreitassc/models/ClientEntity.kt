package com.danielfreitassc.models

class ClientEntity(
    val id: Int,
    val name: String,
    var balance: Double
) {

    fun addBalance(value: Double) {
        balance+= value
    }
}