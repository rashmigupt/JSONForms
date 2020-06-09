package com.example.samplemoneyloji.model

import com.google.gson.annotations.SerializedName

data class Validator(
    val type: String,
    @SerializedName("Value")
    val value: String
)
