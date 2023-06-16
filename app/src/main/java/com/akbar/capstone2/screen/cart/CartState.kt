package com.akbar.capstone2.screen.cart

import com.akbar.capstone2.model.OrderProduct


data class CartState(
    val orderProduct: List<OrderProduct>,
    val totalPrice: Int
)