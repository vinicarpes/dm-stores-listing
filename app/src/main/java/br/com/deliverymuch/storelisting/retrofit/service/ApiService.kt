package br.com.deliverymuch.storelisting.retrofit.service

import br.com.deliverymuch.storelisting.dto.RemoteCompanies
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("v6.1/companies?lat={lat}&lng={lng}type=Todos")
    suspend fun fetchCompanies(@Path("lat") lat: Double, @Path("lng") lng: Double): RemoteCompanies
}