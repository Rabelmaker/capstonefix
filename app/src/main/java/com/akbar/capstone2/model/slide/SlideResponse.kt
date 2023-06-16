package com.akbar.capstone2.model.slide

data class SlideResponse(
    val status : Boolean,
    val msg : String,
    val rec : List<SlideModel>
)
