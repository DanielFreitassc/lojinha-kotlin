package com.danielfreitassc.models

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class ClientEntity(
    val id: Int,
    val name: String,
    var balance: Double
) {
    fun addBalance(amount: Double) {
        balance += amount
    }

    fun canAfford(amount: Double): Boolean = balance >= amount

    @Composable
    fun showDetails() {
        Text(
            text = """
                ID: $id
                Nome: $name
                Saldo: R$ $balance
            """.trimIndent()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun testClient() {
    val person = ClientEntity(1, "Gean", 200.9)
    person.showDetails()
}
