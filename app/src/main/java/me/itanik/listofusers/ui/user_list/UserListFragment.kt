package me.itanik.listofusers.ui.user_list

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import me.itanik.listofusers.R

class UserListFragment : Fragment(R.layout.fragment_user_list) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.detailsButton).setOnClickListener {
            findNavController().navigate(R.id.action_userListFragment_to_userDetailsFragment)
        }
    }
}