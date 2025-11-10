package br.com.deliverymuch.storelisting.usecase

import android.util.Log
import br.com.deliverymuch.storelisting.retrofit.service.ApiService
import javax.inject.Inject

class CompanyUseCase @Inject constructor(private val apiService: ApiService) {
    suspend fun fetchCompanies(lat: Double, lng: Double) {
        val response = apiService.fetchCompanies(lat, lng)
        Log.d("REMOTE_COMPANIES", response.toString())
    }
}