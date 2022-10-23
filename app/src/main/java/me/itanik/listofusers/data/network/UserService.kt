package me.itanik.listofusers.data.network

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.http.GET

interface UserService {
    @GET("v0/b/candidates--questionnaire.appspot.com/o/users.json?alt=media&token=e3672c23-b1a5-4ca7-bb77-b6580d75810c")
    suspend fun getUserList(): Response<ResponseBody>

    companion object {
        fun create(): UserService {
            return Retrofit.Builder()
                .baseUrl("https://firebasestorage.googleapis.com/")
                .build()
                .create(UserService::class.java)
        }
    }
}