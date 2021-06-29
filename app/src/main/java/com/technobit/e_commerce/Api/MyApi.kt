package com.technobit.e_commerce.Api

import com.technobit.e_commerce.Model.UserAccount
import retrofit2.Call
import retrofit2.http.*


interface MyApi {

    @FormUrlEncoded
    @POST("/api/login")
    fun login(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<UserAccount>

    @FormUrlEncoded
    @POST("/register")
    fun register(@Field("name") name: String,
                 @Field("email") email: String,
                 @Field("password") password: String
    ): Call<UserAccount>

}