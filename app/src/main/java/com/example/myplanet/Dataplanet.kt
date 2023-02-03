package com.example.myplanet

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Dataplanet(
    var namePlanet : String,
    var photoPlanet : Int
):Parcelable
