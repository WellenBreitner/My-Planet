package com.example.myplanet

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataAstronaut(
    var PhotoAstronaut: Int,
    var nameAstronaut: String,
    var descAstronaut: String
) : Parcelable