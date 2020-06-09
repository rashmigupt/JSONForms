package com.example.samplemoneyloji

import com.example.samplemoneyloji.model.Validator

data class Field(
    val id: String,
    val type: String,
    val label: String,
    val hintText: String,
    val required: String,
    val validator: List<Validator>
)
