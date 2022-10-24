package me.itanik.listofusers.data.repository

import me.itanik.listofusers.data.network.UserService
import me.itanik.listofusers.data.network.dto.EyeColor
import me.itanik.listofusers.data.network.dto.FavoriteFruit
import me.itanik.listofusers.data.network.dto.UserDto
import me.itanik.listofusers.data.persistence.dao.UserDao
import me.itanik.listofusers.data.persistence.entity.UserEntity
import java.util.*
import javax.inject.Inject

data class User(
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
    val friends: List<Int>
)

interface UserRepository {
    suspend fun getUsers(): List<User>
    suspend fun getUser(userId: Int): User
    suspend fun getUsersByIds(userIds: List<Int>): List<User>
    suspend fun updateData()
}

class UserRepositoryImpl @Inject constructor(
    private val userDao: UserDao,
    private val userService: UserService
) : UserRepository {
    override suspend fun getUsers(): List<User> {
        enshureUpdated()
        return userDao.getAll().map { it.toUser() }
    }

    override suspend fun getUser(userId: Int): User {
        enshureUpdated()
        return userDao.getById(userId).toUser()
    }

    override suspend fun getUsersByIds(userIds: List<Int>): List<User> {
        enshureUpdated()
        return userDao.getAllByIds(userIds.toIntArray()).map { it.toUser() }
    }

    override suspend fun updateData() {
        val users = userService.getUserList().map { it.toUserEntity() }
        userDao.insertAll(users)
    }

    private suspend fun enshureUpdated() {
        if (userDao.getAll().isEmpty())
            updateData()
    }

}

fun UserDto.toUserEntity() = UserEntity(
    id = this.id,
    name = this.name,
    email = this.email,
    isActive = this.isActive,
    address = this.address,
    phone = this.phone,
    age = this.age,
    company = this.company,
    eyeColor = this.eyeColor,
    favoriteFruit = this.favoriteFruit,
    registered = this.registered,
    latitude = this.latitude,
    longitude = this.longitude,
    about = this.about,
    friends = this.friends.map { it.id }
)

fun UserEntity.toUser() = User(
    id = this.id,
    name = this.name,
    email = this.email,
    isActive = this.isActive,
    address = this.address,
    phone = this.phone,
    age = this.age,
    company = this.company,
    eyeColor = this.eyeColor,
    favoriteFruit = this.favoriteFruit,
    registered = this.registered,
    latitude = this.latitude,
    longitude = this.longitude,
    about = this.about,
    friends = this.friends
)
