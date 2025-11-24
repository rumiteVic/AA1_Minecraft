package com.example.aa1_minecraft.classes

import androidx.annotation.DrawableRes

data class Crafteos(
    val name: String,
    val description: String?,
    val versionImplementada: Float,
    @DrawableRes val imageResourceID: Int
)