package br.com.deliverymuch.storelisting.retrofit.service

import br.com.deliverymuch.storelisting.dto.RemoteStores
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("v7.0/companies?lat={lat}&lng={lng}&delivery_method=ALL")
    suspend fun getLojas(@Path("lat") lat: Double, @Path("lng") lng: Double): RemoteStores
}