package br.com.deliverymuch.storelisting.dto

import br.com.deliverymuch.storelisting.domain.models.RemoteCompany
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteCompanies(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("data")
    val data: List<RemoteCompany>
)