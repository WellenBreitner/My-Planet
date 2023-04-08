package com.example.myplanet

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataApollo  (
    var nameApollo : String,
    var photoAppolo : Int,
    var descApollo : String
    ): Parcelable