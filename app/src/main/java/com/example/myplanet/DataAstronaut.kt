package com.example.myplanet

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataAstronaut(
    var photoAstronaut: Int,
    var nameAstronaut: String,
    var descAstronaut: String
) : Parcelable