package com.danielfreitassc.models

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

class StoreEntity {
    private val availableProducts: MutableList<ProductEntity> = mutableListOf(
        ProductEntity(1, "Notebook", 2500.0, 5),
        ProductEntity(2, "Mouse", 150.0, 10)
    )

    @Composable
    fun listarProdutos() {
        if (availableProducts.isEmpty()) {
            Text("Não há produtos disponíveis na loja.")
        } else {
            availableProducts.forEach { it.showDetails() }
        }
    }

    @Composable
    fun finalizarCompra(cliente: ClientEntity, carrinho: ShoppingCartEntity) {
        val totalCompra = carrinho.total()
        if (cliente.canAfford(totalCompra)) {
            cliente.balance -= totalCompra
            carrinho.fetchProducts().forEach { product ->
                availableProducts.find { it.id == product.id }?.let {
                    it.stock = (it.stock - 1).coerceAtLeast(0)
                }
            }
            carrinho.products.clear()

            Text("Compra realizada com sucesso! Total: R$ $totalCompra.")
            Text("Saldo restante: R$ ${cliente.balance}")
        } else {
            Text("Saldo insuficiente para realizar a compra.")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun testStore() {
    val loja = StoreEntity()
    loja.listarProdutos()
}
