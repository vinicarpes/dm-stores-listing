package br.com.deliverymuch.storelisting.domain.models

import kotlinx.serialization.SerialName

data class RemoteAddress(
    @SerialName("street")
    val street: String,
    @SerialName("city")
    val city: String,
    @SerialName("neighborhood")
    val neighborhood: String,
    @SerialName("zip_code")
    val zipCode: String
)
