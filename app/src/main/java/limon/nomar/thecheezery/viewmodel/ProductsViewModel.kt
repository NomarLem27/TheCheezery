package limon.nomar.thecheezery.viewmodel

import limon.nomar.thecheezery.data.ProductsDAO
import limon.nomar.thecheezery.domain.Product
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel

class ProductViewModel(private val dao: ProductsDAO): ViewModel() {
    var productsListState by mutableStateOf(listOf<Product>())

    fun saveProduct(product: Product) {
        val newProduct = dao.insertProduct(product)
        if (newProduct != -1L) {
            getAllProducts()
        }
    }

    fun getAllProducts() {
        productsListState = dao.getAllProducts()
    }

    fun getProductsByType(type: String) {
        productsListState = dao.getProductsByType(type)
    }
}