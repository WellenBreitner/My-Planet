package com.example.myplanet

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataPlanet(
    var namePlanet: String,
    var photoPlanet: Int,
    var descriptionPlanet: String,
    var temperaturePlanet: Int,
    var rotationPlanet: Int,
    var diameterPlanet: Int,
    var distancePlanet: Int,
    var temperaturePlanetText: String,
    var rotationPlanetText: String,
    var diameterPlanetText: String,
    var distancePlanetText: String
) : Parcelable
