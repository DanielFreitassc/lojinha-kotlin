package com.danielfreitassc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.danielfreitassc.models.CartEntity
import com.danielfreitassc.models.ClientEntity
import com.danielfreitassc.models.ProductEntity
import com.danielfreitassc.models.StoreEntity
import com.danielfreitassc.ui.theme.LojinhakotlinTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LojinhakotlinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    StoreController(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun StoreController(modifier: Modifier = Modifier) {
    val product1 = ProductEntity(1, "Notebook", 4500.0, 5)
    val product2 = ProductEntity(2, "Gamer Mouse", 250.0, 10)

    val client = ClientEntity(1, "Ana", 5000.0)

    val cart = CartEntity()
    val store = StoreEntity(mutableListOf(product1, product2))

    Column(modifier = modifier.padding(16.dp)) {
        Card(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Products in Store:")
                product1.showDetails()
                product2.showDetails()

                Spacer(modifier = Modifier.height(16.dp))

                Text("Client: ${client.name}, Balance: R$ ${client.balance}")

                Spacer(modifier = Modifier.height(16.dp))

                Text("Adding products to cart...")
                cart.addProduct(product1, 1)
                cart.addProduct(product2, 2)

                cart.listProducts()

                Spacer(modifier = Modifier.height(16.dp))

                store.checkout(client, cart)

                cart.listProducts()
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun StoreControllerPreview() {
    LojinhakotlinTheme {
        StoreController()
    }
}