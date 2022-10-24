package me.itanik.listofusers.ui.user_details

import androidx.lifecycle.ViewModel
import me.itanik.listofusers.data.network.UserService
import me.itanik.listofusers.data.network.dto.UserDto
import javax.inject.Inject

class UserDetailsViewModel @Inject constructor(
    private val userService: UserService
) : ViewModel() {

    suspend fun getUser(userId: Int) =
        userService.getUserList().find { it.id == userId } ?: throw Exception("Cannot get user")

    suspend fun getFriends(user: UserDto): List<UserDto> {
        val friendsIds = user.friends.map { it.id }
        return userService.getUserList().filter { friendsIds.contains(it.id) }
    }
}