package com.akbar.capstone2.model

import com.akbar.capstone2.R

data class SlideModel(
    val imageSlide: Int,
    val textSlide: String
)

val dummySlide = listOf(
    SlideModel(R.drawable.slide1, "ini adalah judul dari slide nomor 1 tentang pertanian"),
    SlideModel(R.drawable.slide2, "ini adalah judul dari slide nomor 2 tentang pertanian"),
    SlideModel(R.drawable.slide3, "ini adalah judul dari slide nomor 3 tentang pertanian"),
    SlideModel(R.drawable.slide4, "ini adalah judul dari slide nomor 4 tentang pertanian"),
)



