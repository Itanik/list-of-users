package me.itanik.listofusers.data.network

import com.google.gson.GsonBuilder
import me.itanik.listofusers.data.network.dto.UserDto
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface UserService {
    @GET("v0/b/candidates--questionnaire.appspot.com/o/users.json?alt=media&token=e3672c23-b1a5-4ca7-bb77-b6580d75810c")
    suspend fun getUserList(): List<UserDto>

    companion object {
        fun create(): UserService {
            return Retrofit.Builder()
                .baseUrl("https://firebasestorage.googleapis.com/")
                .addConverterFactory(
                    GsonConverterFactory.create(
                        GsonBuilder()
                            .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                            .create()
                    )
                )
                .build()
                .create(UserService::class.java)
        }
    }
}