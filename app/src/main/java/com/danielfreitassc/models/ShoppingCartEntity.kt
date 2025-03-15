package com.danielfreitassc.models

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class ShoppingCartEntity {
    val products: MutableList<ProductEntity> = mutableListOf()

    fun addToCart(product: ProductEntity) {
        if (product.stock > 0) {
            products.add(product)
            product.stock--
        }
    }

    fun removeFromCart(product: ProductEntity) {
        if (products.remove(product)) {
            product.stock++
        }
    }

    fun fetchProducts(): List<ProductEntity> = products.toList()

    fun total(): Double = products.sumOf { it.price }

    @Composable
    fun exibirCarrinho() {
        if (products.isEmpty()) {
            Text("O carrinho está vazio.")
        } else {
            Text("Produtos no carrinho:")
            products.forEach { it.showDetails() }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun testCart() {
    val carrinho = ShoppingCartEntity()
    carrinho.addToCart(ProductEntity(1, "Teclado", 300.0, 2))
    carrinho.exibirCarrinho()
}
