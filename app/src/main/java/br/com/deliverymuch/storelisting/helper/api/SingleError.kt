package br.com.deliverymuch.storelisting.helper.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SingleError(
    @SerialName("title")
    val title: String? = null,
    @SerialName("message")
    val message: String? = null
) {
    override fun toString() = message ?: ""
}