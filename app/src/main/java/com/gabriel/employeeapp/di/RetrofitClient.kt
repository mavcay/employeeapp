package com.gabriel.employeeapp.di

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "http://192.168.X.XXX:8080/" //EDIT THE IP ADDRESS BASED ON YOUR IP ADDRESS, GO TO CMD AND ENTER IPCONFIG, THEN PASTE YOUR IP HERE, DONT CHANGE THE 8080

    val instance: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
