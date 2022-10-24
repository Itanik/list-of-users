package me.itanik.listofusers.data.persistence.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import me.itanik.listofusers.data.persistence.entity.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM users")
    fun getAll(): List<UserEntity>

    @Query("SELECT * FROM users WHERE id IN (:userIds)")
    fun getAllByIds(userIds: IntArray): List<UserEntity>

    @Query("SELECT * FROM users WHERE id = :userId")
    fun getById(userId: Int): UserEntity

    @Insert
    fun insertAll(users: List<UserEntity>)

    @Delete
    fun delete(user: UserEntity)
}