package me.itanik.listofusers.data.persistence.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import me.itanik.listofusers.data.network.dto.EyeColor
import me.itanik.listofusers.data.network.dto.FavoriteFruit
import java.util.*

@Entity(tableName = "users")
data class UserEntity(
    @PrimaryKey val id: String,
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
    val friends: List<Int>
)
