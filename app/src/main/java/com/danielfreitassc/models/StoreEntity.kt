package com.danielfreitassc.models

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class StoreEntity(
    val available: MutableList<ProductEntity> = mutableListOf()
) {

    @Composable
    fun checkout(clientEntity: ClientEntity,cartEntity: CartEntity) {
        val total = cartEntity.calculateProducts()

        if(clientEntity.balance >= total) {
            Text(text = "Compra realizada")
        clientEntity.balance -= total
        cartEntity.products.forEach{it.stock - 1}
        cartEntity.products.clear()
        } else {
            Text("Saldo insuficiente")
        }
    }
}