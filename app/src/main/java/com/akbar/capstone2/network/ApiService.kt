package com.akbar.capstone2.network

import com.akbar.capstone2.model.auth.ApiModel
import com.akbar.capstone2.model.auth.ApiRegister
import com.akbar.capstone2.model.auth.LoginModel
import com.akbar.capstone2.model.auth.RegisterModel
import com.akbar.capstone2.model.recomend.ApiRecommend
import com.akbar.capstone2.model.recomend.RecomendModel
import com.akbar.capstone2.model.slide.SlideResponse
import retrofit2.http.*

interface ApiService {
    @POST("register")
    suspend fun register(@Body request: RegisterModel): ApiRegister


    @POST("login")
    suspend fun login(@Body request: LoginModel): ApiModel
    @POST("predict")
    suspend fun predict(@Body request: RecomendModel): ApiRecommend

    @GET("article")
    suspend fun getSlides(): SlideResponse
}
