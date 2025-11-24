package br.com.deliverymuch.storelisting.usecase

import android.util.Log
import br.com.deliverymuch.storelisting.helper.api.ApiHelper
import br.com.deliverymuch.storelisting.retrofit.service.ApiService

class DefaultCompanyUseCaseImpl(
    private val apiService: ApiService,
    private val apiHelper: ApiHelper
) :
    FetchCompanyUseCase {
    override suspend fun fetchCompanies(lat: Double, lng: Double) {
        try {
            val response = apiService.fetchCompanies(lat, lng)
            Log.d("REMOTE_COMPANIES", response.toString())

            if (response?.totalCount == 0) {
                UseCase.Response.Failure(
                    UseCase.FailureReason.NotFound
                )
            }
            if (response?.totalCount == null) {
                UseCase.Response.Failure(
                    UseCase.FailureReason.MissingLocation
                )
            }

            response?.let {
                UseCase.Response.Success(data = response)
            }

        } catch (t: Throwable) {
            val apiError = apiHelper.parseErrorBody(t)
            if (apiError != null) {
                UseCase.Response.Failure(
                    UseCase.FailureReason.Api(
                        apiError = apiError
                    )
                )
            } else {
                UseCase.Response.Failure(
                    UseCase.FailureReason.Generic(t)
                )
            }
        }
    }
}