package com.danielfreitassc.models

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class ProductEntity(
    val id: Int,
    val name: String,
    var price: Double,
    var stock: Int
) {
    @Composable
    fun showDetails() {
        Text(
            text = """
                ID: $id
                Nome: $name
                Preço: R$ $price
                Estoque: $stock
            """.trimIndent()
        )
    }
}

@Preview(showBackground = true)
@Composable
fun testProduct() {
    val p = ProductEntity(1, "PC", 200.0, 20)
    p.showDetails()
}
