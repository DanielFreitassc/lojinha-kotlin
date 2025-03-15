package com.danielfreitassc


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.danielfreitassc.models.ClientEntity
import com.danielfreitassc.models.ProductEntity
import com.danielfreitassc.models.ShoppingCartEntity
import com.danielfreitassc.models.StoreEntity
import com.danielfreitassc.ui.theme.LojinhaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            LojinhaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LojaScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun LojaScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val product1 = ProductEntity(1, "Notebook", 4500.0, 5)
        val product2 = ProductEntity(2, "Mouse Gamer", 250.0, 10)
        val client = ClientEntity(1, "Geanlucca", 5000.0)
        val shoppingCart = ShoppingCartEntity()
        val store = StoreEntity()



        shoppingCart.addToCart(product1)
        shoppingCart.addToCart(product2)

        LojaCard(client, store, shoppingCart)
    }
}

@Composable
fun LojaCard(client: ClientEntity, store: StoreEntity, shoppingCart: ShoppingCartEntity) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Bem-vindo à Lojinha!", fontSize = 20.sp)

            Spacer(modifier = Modifier.size(12.dp))

            Text("Cliente: ${client.name}", fontSize = 24.sp)
            Text("Saldo: R$${client.balance}", fontSize = 21.sp, color = Color.Green)

            Spacer(modifier = Modifier.size(12.dp))

            Text("Produtos Disponíveis:", fontSize = 24.sp)
            store.listarProdutos()

            Spacer(modifier = Modifier.size(12.dp))

            Text("Carrinho:", fontSize = 24.sp)
            shoppingCart.exibirCarrinho()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LojaScreenPreview() {
    LojinhaTheme {
        LojaScreen()
    }
}
