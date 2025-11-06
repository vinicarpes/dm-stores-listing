package br.com.deliverymuch.storelisting.domain.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import java.math.BigDecimal

@Serializable
data class RemoteCompany(
    @SerialName("uuid")
    val uuid: String,
    @SerialName("name")
    val name: String,
    @SerialName("slug")
    val slug: String,
    @SerialName("image")
    val image: String,
    @SerialName("phone")
    val phone: String,
    @SerialName("is_online")
    val isOnline: Boolean,
    @SerialName("delivery_time")
    val deliveryTime: Int,
    @SerialName("cooking_time")
    val cookingTime: Int,
    @SerialName("can_pickup")
    val canPickup: Boolean,
    @SerialName("location")
    val location: String,
    @SerialName("minimum_order_price")
    val minimumOrderPrice: Int,
    @SerialName("description")
    val description: String,
    @SerialName("categories")
    val categories: List<RemoteCategory>,
    @SerialName("payment_methods")
    val paymentMethods: List<RemotePaymentMethod>,
    @SerialName("badges")
    val badges: List<RemoteBadge>,
    @SerialName("address")
    val address: RemoteAddress,
    @SerialName("company_type")
    val companyType: String,
    @SerialName("formatted_address")
    val formattedAddress: String,
    @SerialName("city_id")
    val cityId: Int,
    @SerialName("distance")
    val distance: BigDecimal,
    @SerialName("new")
    val isNew: Boolean
)