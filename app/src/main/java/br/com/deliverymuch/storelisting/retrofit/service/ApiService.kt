package br.com.deliverymuch.storelisting.retrofit.service

import br.com.deliverymuch.storelisting.dto.RemoteCompanies
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v6.1/companies")
    suspend fun fetchCompanies(
        @Query("lat") lat: Double,
        @Query("lng") lng: Double,
        @Query("type") type: String = "Todos"
    ): RemoteCompanies?
}