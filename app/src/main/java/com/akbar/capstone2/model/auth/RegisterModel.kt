package com.akbar.capstone2.model.auth

data class RegisterModel(
    val name: String,
    val email: String,
    val no_hp : String,
    val password: String,
    val confirmPassword: String
)