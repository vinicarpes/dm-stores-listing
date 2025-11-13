package br.com.deliverymuch.storelisting.domain.models

import kotlinx.serialization.SerialName
import java.io.Serial

data class RemoteBadge(
    @SerialName("campaign_id")
    val campaignId: String,
    @SerialName("name")
    val name: String,
    @SerialName("badge_image_url")
    val badgeImageUrl: String,
    @SerialName("rule")
    val rule: String,
    @SerialName("description")
    val description: String,
    @SerialName("type")
    val type: String,
    @SerialName("campaign_type")
    val campaignType: String
)