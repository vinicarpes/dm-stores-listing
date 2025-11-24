package br.com.deliverymuch.storelisting.helper.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.Unit.toString

@Serializable
data class ApiError(
    @SerialName("request_id")
    val requestId: String? = null,

    @SerialName("errors")
    val errors: List<SingleError>? = null
) : Throwable(message = toString()) {

    val hasErrors: Boolean
        get() = errors != null && errors.isNotEmpty()

    override fun toString() = if (errors.isNullOrEmpty()) {
        ""
    } else {
        errors.joinToString(separator = " ") { it.message ?: "" }.trim()
    }
}