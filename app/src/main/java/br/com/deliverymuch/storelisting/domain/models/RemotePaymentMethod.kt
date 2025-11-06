package br.com.deliverymuch.storelisting.domain.models

import kotlinx.serialization.SerialName

data class RemotePaymentMethod(
    @SerialName("id")
    val id: Int,
    @SerialName("name")
    val name: String,
    @SerialName("type")
    val type: String
)