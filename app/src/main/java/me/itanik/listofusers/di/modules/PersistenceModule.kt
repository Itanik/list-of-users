package me.itanik.listofusers.di.modules

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import me.itanik.listofusers.data.persistence.AppDatabase
import me.itanik.listofusers.data.persistence.dao.UserDao
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Singleton
    @Provides
    fun provideAppDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.DB_NAME).build()

    @Provides
    fun provideUserDao(appDatabase: AppDatabase): UserDao = appDatabase.userDao()
}