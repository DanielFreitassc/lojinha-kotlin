package com.danielfreitassc.models

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

class CartEntity(
    val products: MutableList<ProductEntity> = mutableListOf()
) {

    @Composable
    fun listProducts() {
        products.forEach({it.showDetails()})
    }

    fun addProduct(productEntity:ProductEntity, quantity: Int) {
        for(i in 1..quantity) {
           products.add(productEntity)
        }
    }

    fun removeProduct(productEntity: ProductEntity) {
        products.remove(productEntity)
    }

    @Composable
    fun calculateProducts(): Double {
        var total = 0.0
        products.forEach{total += it.price}
        Text("Total:R$ $total")
        return total
    }

}