package com.example.weatherapp.data.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class TranslationRequest(
    @SerialName("text") val text: String,
    @SerialName("target_lang") val targetLang: String
)