package me.itanik.listofusers.ui.user_list

import androidx.lifecycle.ViewModel
import me.itanik.listofusers.data.network.UserService

class UserListViewModel : ViewModel() {
    private val apiClient = UserService.create()

    suspend fun getUsers() = apiClient.getUserList()
}