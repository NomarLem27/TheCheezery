package limon.nomar.thecheezery.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import limon.nomar.thecheezery.R
import limon.nomar.thecheezery.components.ProductForm
import limon.nomar.thecheezery.domain.Product

@Composable
fun ProductsScreen(
    innerPadding: PaddingValues,
    products: List<Product>,
    onSaveProduct: (
        name: String,
        price: Float,
        image: String,
        description: String
    ) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
    ) {

        Text(
            text = "The Cheezery",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(20.dp))

        ProductForm(innerPadding, onSaveProduct)

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Products",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier = Modifier.height(10.dp))

        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            items(products) { product ->

                Card(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Image(
                            painter = painterResource(R.drawable.ic_launcher_background),
                            contentDescription = "product image",
                            modifier = Modifier.size(80.dp)
                        )

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text(
                                text = product.name,
                                fontWeight = FontWeight.Bold,
                                fontSize = 20.sp
                            )

                            product.description?.let {
                                Text(
                                    text = it,
                                    style = MaterialTheme.typography.bodyMedium
                                )
                            }
                        }

                        Text(
                            text = "$${product.price}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductsScreenPreview() {

    ProductsScreen(
        PaddingValues(0.dp),

        listOf(
            Product(
                1,
                "Latte",
                50f,
                "",
                "Café delicioso"
            ),

            Product(
                2,
                "Capuccino",
                65f,
                "",
                "Con espuma cremosa"
            )
        )

    ) { _, _, _, _ -> }
}