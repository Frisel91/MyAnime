package com.example.myanime.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Anime(
    val id: Int,
    @DrawableRes val imageRes: Int,
    @StringRes val nameRes: Int,
    val dateRes: String,
    val serialRes: String
)
