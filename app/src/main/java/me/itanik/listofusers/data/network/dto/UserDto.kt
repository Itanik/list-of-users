package me.itanik.listofusers.data.network.dto

import com.google.gson.annotations.SerializedName
import java.util.*

data class UserDto(
    val id: Int,
    val name: String,
    val email: String,
    val isActive: Boolean,
    val address: String,
    val phone: String,
    val age: Int,
    val company: String,
    val eyeColor: EyeColor,
    val favoriteFruit: FavoriteFruit,
    val registered: Date,
    val latitude: Double,
    val longitude: Double,
    val about: String,
    val friends: List<FriendDto>
)

data class FriendDto(
    val id: Int
)

enum class EyeColor {
    @SerializedName("brown")
    BROWN,

    @SerializedName("blue")
    BLUE,

    @SerializedName("green")
    GREEN
}

enum class FavoriteFruit {
    @SerializedName("banana")
    BANANA,

    @SerializedName("apple")
    APPLE,

    @SerializedName("strawberry")
    STRAWBERRY
}