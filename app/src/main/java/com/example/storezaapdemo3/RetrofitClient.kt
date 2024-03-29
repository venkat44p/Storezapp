package com.example.storezaapdemo3


import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient private constructor() {

   // private val BASE_URL = "http://192.168.174.90/StorezApp/"
    //private val builder = OkHttpClient.Builder()
   // private val interceptor = HttpLoggingInterceptor()

    init {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        //interceptor.level = HttpLoggingInterceptor.Level.BODY
        //builder.addInterceptor(interceptor)

        retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.1.236/")
            .client(OkHttpClient.Builder().build())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    companion object {
        private var retrofitClient: RetrofitClient? = null
        private lateinit var retrofit: Retrofit

        @Synchronized
        fun getInstance(): RetrofitClient {
            if (retrofitClient == null) {
                retrofitClient = RetrofitClient()
            }
            return retrofitClient as RetrofitClient
        }
    }

    fun getApi(): Api {
        return retrofit.create(Api::class.java)
    }
}