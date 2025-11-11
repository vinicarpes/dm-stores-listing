package br.com.deliverymuch.storelisting.retrofit.service

import retrofit2.http.GET

interface ApiService {
    @GET("/ping")
    suspend fun ping()

}