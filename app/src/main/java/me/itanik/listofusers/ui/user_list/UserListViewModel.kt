package me.itanik.listofusers.ui.user_list

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import me.itanik.listofusers.data.network.UserService

class UserListViewModel : ViewModel() {
    private val apiClient = UserService.create()

    init {
        viewModelScope.launch(IO) {
            val response = apiClient.getUserList()
            val json = response.body()?.string()
            Log.d("UserListViewModel", json ?: "null")
        }
    }
}