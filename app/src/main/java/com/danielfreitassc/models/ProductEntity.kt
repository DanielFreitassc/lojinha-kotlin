package com.danielfreitassc.models

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class ProductEntity(
    val id: Int,
    val name: String,
    var price: Double,
    var stock: Int
) {

    @Composable
    fun showDetails() {
        Text("""
            Id: $id,
            Nome: $name,
            Preço: $price,
            Estoque: $stock
        """.trimIndent())
    }
}

