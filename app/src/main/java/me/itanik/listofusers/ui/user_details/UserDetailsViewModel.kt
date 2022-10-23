package me.itanik.listofusers.ui.user_details

import androidx.lifecycle.ViewModel
import me.itanik.listofusers.data.network.UserService
import me.itanik.listofusers.data.network.dto.UserDto

class UserDetailsViewModel : ViewModel() {
    private val apiClient = UserService.create()

    suspend fun getUser(userId: Int) =
        apiClient.getUserList().find { it.id == userId } ?: throw Exception("Cannot get user")

    suspend fun getFriends(user: UserDto): List<UserDto> {
        val friendsIds = user.friends.map { it.id }
        return apiClient.getUserList().filter { friendsIds.contains(it.id) }
    }
}