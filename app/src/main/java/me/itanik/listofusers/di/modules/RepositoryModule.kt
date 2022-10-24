package me.itanik.listofusers.di.modules

import dagger.Module
import dagger.Provides
import me.itanik.listofusers.data.network.UserService
import me.itanik.listofusers.data.persistence.dao.UserDao
import me.itanik.listofusers.data.repository.UserRepository
import me.itanik.listofusers.data.repository.UserRepositoryImpl

@Module
class RepositoryModule {

    @Provides
    fun provideUserRepository(userDao: UserDao, userService: UserService): UserRepository =
        UserRepositoryImpl(userDao, userService)
}