package me.itanik.listofusers.ui.user_details

import androidx.lifecycle.ViewModel
import me.itanik.listofusers.data.repository.User
import me.itanik.listofusers.data.repository.UserRepository
import javax.inject.Inject

class UserDetailsViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    suspend fun getUser(userId: Int) = userRepository.getUser(userId)

    suspend fun getFriends(user: User): List<User> = userRepository.getUsersByIds(user.friends)
}