package com.example.samplemoneyloji

import com.google.gson.annotations.SerializedName

data class Form(
    @SerializedName("data")
    val fields: List<Field>
)
