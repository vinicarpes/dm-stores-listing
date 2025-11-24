package br.com.deliverymuch.storelisting.usecase

internal interface FetchCompanyUseCase : UseCase {
    suspend fun fetchCompanies(lat: Double, lng: Double)
}