package me.itanik.listofusers.di.modules

import dagger.Module
import dagger.Provides
import me.itanik.listofusers.data.network.UserService

@Module
class NetworkModule {

    @Provides
    fun provideUserRetrofitService(): UserService = UserService.create()
}