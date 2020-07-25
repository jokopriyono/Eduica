package com.developer.eduica.models.responses

import com.google.gson.annotations.SerializedName

data class DataLoginToken(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("token_type")
    val tokenType: String
)
