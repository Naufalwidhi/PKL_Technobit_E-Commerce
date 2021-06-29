package com.technobit.e_commerce.Api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object MyClient {

    val  retrofit = Retrofit.Builder()
        .baseUrl("https://kiospedia.000webhostapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun myApiClient() = retrofit.create(MyApi::class.java)

}