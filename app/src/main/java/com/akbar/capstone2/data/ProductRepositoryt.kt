package com.akbar.capstone2.data

import com.akbar.capstone2.model.FakeProductDataSource
import com.akbar.capstone2.model.OrderProduct
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map

class ProductRepository {

    private val orderProduct = mutableListOf<OrderProduct>()

    init {
        if (orderProduct.isEmpty()) {
            FakeProductDataSource.dummyProduct.forEach {
                orderProduct.add(OrderProduct(it, 0))
            }
        }
    }

    fun getAllProduct(): Flow<List<OrderProduct>> {
        return flowOf(orderProduct)
    }

    fun getOrderProductById(productId: Long): OrderProduct {
        return orderProduct.first {
            it.product.id == productId
        }
    }

    fun updateOrderProduct(productId: Long, newCountValue: Int): Flow<Boolean> {
        val index = orderProduct.indexOfFirst { it.product.id == productId }
        val result = if (index >= 0) {
            val orderReward = orderProduct[index]
            orderProduct[index] =
                orderReward.copy(product = orderReward.product, count = newCountValue)
            true
        } else {
            false
        }
        return flowOf(result)
    }

    fun getAddedOrderProduct(): Flow<List<OrderProduct>> {
        return getAllProduct()
            .map { orderProduct ->
                orderProduct.filter { orderReward ->
                    orderReward.count != 0
                }
            }
    }

    fun searchProduct(query: String): List<OrderProduct> {
        return orderProduct.filter { orderProduct ->
            orderProduct.product.title.contains(query, ignoreCase = true)
        }
    }

    companion object {
        @Volatile
        private var instance: ProductRepository? = null

        fun getInstance(): ProductRepository =
            instance ?: synchronized(this) {
                ProductRepository().apply {
                    instance = this
                }
            }
    }
}