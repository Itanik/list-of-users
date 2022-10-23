package me.itanik.listofusers.ui.user_list

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import me.itanik.listofusers.R

class UserListFragment : Fragment(R.layout.fragment_user_list) {
    private val viewModel: UserListViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel
        view.findViewById<Button>(R.id.detailsButton).setOnClickListener {
            findNavController().navigate(R.id.action_userListFragment_to_userDetailsFragment)
        }
    }
}