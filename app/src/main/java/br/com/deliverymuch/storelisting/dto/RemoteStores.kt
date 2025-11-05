package br.com.deliverymuch.storelisting.dto

import br.com.deliverymuch.storelisting.domain.models.Store
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RemoteStores(
    @SerialName("total_count")
    val totalCount: Int,
    val data: List<Store>
)