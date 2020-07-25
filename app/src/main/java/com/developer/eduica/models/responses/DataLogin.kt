package com.developer.eduica.models.responses

import com.google.gson.annotations.SerializedName
import java.util.*

data class DataLogin(
    @SerializedName("id")
    val idUser: Int,
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("username")
    val username: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("created_at")
    val createdAt: Date,
    @SerializedName("updated_at")
    val updatedAt: Date,

    @SerializedName("token")
    val token: DataLoginToken
)
