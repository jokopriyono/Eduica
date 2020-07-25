package com.developer.eduica

import com.developer.eduica.models.bodies.LoginBody
import com.developer.eduica.models.responses.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    @POST("auth/login")
    fun login(@Body body: LoginBody): Call<LoginResponse>

}