package me.itanik.listofusers.ui.user_list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import me.itanik.listofusers.R
import me.itanik.listofusers.data.network.dto.UserDto
import me.itanik.listofusers.databinding.ItemUserListBinding

class UserListAdapter : ListAdapter<UserDto, UserItemViewHolder>(UserDiffCallback) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserItemViewHolder {
        return UserItemViewHolder(
            ItemUserListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: UserItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class UserItemViewHolder(private val binding: ItemUserListBinding) : ViewHolder(binding.root) {
    fun bind(user: UserDto) {
        with(binding) {
            userName.text = user.name
            userEmail.text = user.email
            userStatus.background = ContextCompat.getDrawable(
                root.context,
                if (user.isActive)
                    R.drawable.ic_green_circle
                else
                    R.drawable.ic_red_circle
            )

        }
    }
}

private object UserDiffCallback : DiffUtil.ItemCallback<UserDto>() {
    override fun areItemsTheSame(oldItem: UserDto, newItem: UserDto): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserDto, newItem: UserDto): Boolean {
        return oldItem == newItem
    }
}