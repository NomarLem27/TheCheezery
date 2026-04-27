package limon.nomar.thecheezery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import limon.nomar.thecheezery.domain.Product
import limon.nomar.thecheezery.screens.ProductsScreen
import limon.nomar.thecheezery.ui.theme.TheCheezeryTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {

            TheCheezeryTheme {

                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->

                    ProductsScreen(
                        innerPadding = innerPadding,

                        products = listOf(
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
                                "Con espuma"
                            )
                        ),

                        onSaveProduct = { name, price, image, description ->

                        }
                    )
                }
            }
        }
    }
}

