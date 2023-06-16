package com.akbar.capstone2.di

import com.akbar.capstone2.data.ProductRepository


object Injection {
    fun provideRepository(): ProductRepository {
        return ProductRepository.getInstance()
    }
}