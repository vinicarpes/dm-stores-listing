package br.com.deliverymuch.storelisting.usecase

import br.com.deliverymuch.storelisting.dto.RemoteCompanies
import br.com.deliverymuch.storelisting.helper.api.ApiError
import br.com.deliverymuch.storelisting.helper.errors.ErrorCode

internal interface FetchCompanyUseCase {
    sealed interface FetchCompanyResponse {
        data class CompanyLoaded(val data: RemoteCompanies) : FetchCompanyResponse

        data class Failure(val reason: FetchCompanyFailureReason) : FetchCompanyResponse
    }

    sealed interface FetchCompanyFailureReason : ErrorCode {
        override val rawCode: String
            get() = "request_error"

        val message: String?
            get() = null

        val throwable: Throwable?
            get() = null

        data class Generic(override val throwable: Throwable) : FetchCompanyFailureReason

        data class Api(val apiError: ApiError) : FetchCompanyFailureReason {
            override val message: String get() = apiError.toString()
            override val throwable: Throwable get() = apiError
        }

        data object NotFound : FetchCompanyFailureReason {
            override val rawCode: String = "not_found"
        }

        data object MissingLocation : FetchCompanyFailureReason {
            override val rawCode: String = "coordinate_required"
        }
    }
}