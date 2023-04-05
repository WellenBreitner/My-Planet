package com.example.myplanet

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataPlanet(
    var namePlanet: String,
    var photoPlanet: Int,
    var descriptionPlanet: String
) : Parcelable
