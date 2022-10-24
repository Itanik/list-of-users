package me.itanik.listofusers.data.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import me.itanik.listofusers.data.persistence.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    suspend fun getAll(): List<UserEntity>

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    suspend fun getAllByIds(userIds: IntArray): List<UserEntity>

    @Query("SELECT * FROM users WHERE id = :userId")
    suspend fun getById(userId: Int): UserEntity

    @Insert
    suspend fun insertAll(users: List<UserEntity>)

    @Delete
    suspend fun delete(user: UserEntity)
}