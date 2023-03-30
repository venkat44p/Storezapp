package com.example.storezaapdemo3

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {

    @FormUrlEncoded
    @POST("/StorezApp/register.php")
    fun register(
        @Field("username") username: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseBody>

    @FormUrlEncoded
    @POST("/StorezApp/login.php")
    fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<ResponseBody>

}