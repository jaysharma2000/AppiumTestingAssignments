package com.example.fooddeliveryapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Restaurant(
    val id: Int,
    val name: String,
    val image: Int,
    val rating: Double,
    val deliveryTime: String
): Parcelable

@Parcelize
data class MenuItem(
    val id: Int,
    val name: String,
    val image: Int,
    val price: Double
): Parcelable

@Parcelize
data class CartItem(
    val menuItem: MenuItem,
    var quantity: Int
): Parcelable
