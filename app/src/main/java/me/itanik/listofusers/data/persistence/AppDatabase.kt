package me.itanik.listofusers.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import me.itanik.listofusers.data.persistence.dao.UserDao
import me.itanik.listofusers.data.persistence.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1)
@TypeConverters(AppTypeConverters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao

    companion object {
        const val DB_NAME = "user_list_db"
    }
}