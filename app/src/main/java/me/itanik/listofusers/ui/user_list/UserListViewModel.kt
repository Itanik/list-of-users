package me.itanik.listofusers.ui.user_list

import androidx.lifecycle.ViewModel
import me.itanik.listofusers.data.repository.UserRepository
import javax.inject.Inject

class UserListViewModel @Inject constructor(
    private val userRepository: UserRepository
) : ViewModel() {

    suspend fun getUsers() = userRepository.getUsers()

    suspend fun updateUsers() = userRepository.updateData()
}