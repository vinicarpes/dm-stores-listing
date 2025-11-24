package br.com.deliverymuch.storelisting.usecase

import br.com.deliverymuch.storelisting.helper.api.ApiError
import br.com.deliverymuch.storelisting.helper.errors.ErrorCode

interface UseCase {
    sealed interface Response {
        data class Success(val data: Any) : Response

        data class Failure(val reason: FailureReason) : Response
    }

    sealed interface FailureReason : ErrorCode {
        override val rawCode: String
            get() = "request_error"

        val message: String?
            get() = null

        val throwable: Throwable?
            get() = null

        data class Generic(override val throwable: Throwable) : FailureReason

        data class Api(val apiError: ApiError) : FailureReason {
            override val message: String get() = apiError.toString()
            override val throwable: Throwable get() = apiError
        }

        data object NotFound : FailureReason {
            override val rawCode: String = "not_found"
        }

        data object MissingLocation : FailureReason {
            override val rawCode: String = "coordinate_required"
        }
    }
}

