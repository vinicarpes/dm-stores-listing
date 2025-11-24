package br.com.deliverymuch.storelisting.helper.api

interface ApiHelper {

    /**
     * Tries to parse an error body to [ApiError] representation
     *
     * @return the parsed error or null if parsing fails
     */
    fun parseErrorBody(throwable: Throwable): ApiError?
}
