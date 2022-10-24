package me.itanik.listofusers.ui.user_list

import androidx.lifecycle.ViewModel
import me.itanik.listofusers.data.network.UserService
import javax.inject.Inject

class UserListViewModel @Inject constructor(
    private val userService: UserService
) : ViewModel() {

    suspend fun getUsers() = userService.getUserList()
}