package com.example.weatherapp.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TranslateDto(
    @SerialName("translations")
    val translations: List<Translation?>? = null
)