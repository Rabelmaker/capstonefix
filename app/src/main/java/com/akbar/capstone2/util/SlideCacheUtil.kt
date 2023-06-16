package com.akbar.capstone2.util

import android.content.Context
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import java.io.File

object SlideCacheUtil {
    private const val SLIDE_CACHE_DIRECTORY = "slide_cache"

    fun clearSlideCache(context: Context) {
        val glideCacheDir = Glide.getPhotoCacheDir(context)?.absolutePath ?: return
        val slideCacheDir = File(glideCacheDir, SLIDE_CACHE_DIRECTORY)
        if (slideCacheDir.exists()) {
            slideCacheDir.deleteRecursively()
        }
    }

    fun cacheSlideImage(context: Context, imageUrl: String) {
        val requestOptions = RequestOptions()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .skipMemoryCache(true)

        Glide.with(context)
            .load(imageUrl)
            .apply(requestOptions)
            .submit()
    }
}
