package limon.nomar.thecheezery.components


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import limon.nomar.thecheezery.R

@Composable
fun ProductForm(innerPadding: PaddingValues, onSaveProduct: (name: String, price: Float, image: String, description: String) -> Unit){

    var name by remember { mutableStateOf("") }
    var priceField by remember { mutableStateOf("") }
    var image by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Add product")
        Spacer(Modifier.height(30.dp))
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = {Text("Name")}
        )
        OutlinedTextField(
            value = priceField,
            onValueChange = {priceField = it},
            label = {Text("Price")},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Decimal),
            trailingIcon = {
                Image(
                    painter = painterResource(R.drawable.dolar),
                    contentDescription = "Dollar icon")
            }
        )
        OutlinedTextField(
            value = image,
            onValueChange = {image = it},
            label = {Text("Image")}
        )
        OutlinedTextField(
            value = description,
            onValueChange = {description = it},
            label = {Text("Description")}
        )
        Spacer(Modifier.height(15.dp))
        Button(onClick = {onSaveProduct(
            name,
            priceField.toFloatOrNull() ?: 0f,
            image,
            description)}) {
            Text("Save product")
        }
    }

}

@Preview(showBackground = true)
@Composable
fun ProductFormPreview(){
    ProductForm(PaddingValues(20.dp), { name, price, image, description -> })
}