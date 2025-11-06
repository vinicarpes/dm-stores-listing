package br.com.deliverymuch.storelisting.domain.models

import kotlinx.serialization.SerialName

data class RemoteCategory(
    @SerialName("name")
    val name: String
)