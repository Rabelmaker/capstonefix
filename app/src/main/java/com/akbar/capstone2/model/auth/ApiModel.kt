package com.akbar.capstone2.model.auth

data class ApiModel(
    val status: Boolean,
    val msg: String,
    val data : DataUserModel,
    val accessToken: String? = null,
)
