package br.com.deliverymuch.storelisting.usecase

import android.util.Log
import br.com.deliverymuch.storelisting.helper.api.ApiHelper
import br.com.deliverymuch.storelisting.retrofit.service.ApiService
import javax.inject.Inject

class DefaultCompanyUseCaseImpl(
    private val apiService: ApiService,
    private val apiHelper: ApiHelper
) :
    FetchCompanyUseCase {
    suspend fun fetchCompanies(lat: Double, lng: Double) {
        try {
            val response = apiService.fetchCompanies(lat, lng)
            Log.d("REMOTE_COMPANIES", response.toString())

            if (response?.totalCount == 0) {
                FetchCompanyUseCase.FetchCompanyResponse.Failure(
                    FetchCompanyUseCase.FetchCompanyFailureReason.NotFound
                )
            }
            if (response?.totalCount == null) {
                FetchCompanyUseCase.FetchCompanyResponse.Failure(
                    FetchCompanyUseCase.FetchCompanyFailureReason.MissingLocation
                )
            }

            response?.let {
                FetchCompanyUseCase.FetchCompanyResponse.CompanyLoaded(data = response)
            }

        } catch (t: Throwable) {
            val apiError = apiHelper.parseErrorBody(t)
            if (apiError != null) {
                FetchCompanyUseCase.FetchCompanyResponse.Failure(
                    FetchCompanyUseCase.FetchCompanyFailureReason.Api(
                        apiError = apiError
                    )
                )
            } else {
                FetchCompanyUseCase.FetchCompanyResponse.Failure(
                    FetchCompanyUseCase.FetchCompanyFailureReason.Generic(t)
                )
            }
        }
    }
}