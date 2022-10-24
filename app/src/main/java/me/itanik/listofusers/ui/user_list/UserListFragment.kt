package me.itanik.listofusers.ui.user_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch
import me.itanik.listofusers.R
import me.itanik.listofusers.appComponent
import me.itanik.listofusers.databinding.FragmentUserListBinding
import me.itanik.listofusers.ui.NavArguments

class UserListFragment : Fragment() {
    private var _binding: FragmentUserListBinding? = null
    private val binding: FragmentUserListBinding get() = _binding!!
    private val viewModel: UserListViewModel by viewModels {
        requireContext().appComponent.userListViewModelProviderFactory
    }

    private val userListAdapter = UserListAdapter { user ->
        if (user.isActive)
            findNavController().navigate(
                R.id.action_userListFragment_to_userDetailsFragment,
                Bundle().apply {
                    putInt(NavArguments.USER_ID, user.id)
                })
    }

    private val exceptionHandler = CoroutineExceptionHandler { _, exception ->
        Toast.makeText(requireContext(), "Unable to update user list", Toast.LENGTH_SHORT).show()
        binding.swipeRefresh.isRefreshing = false
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch(exceptionHandler) {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                userListAdapter.submitList(viewModel.getUsers())
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            userListRV.adapter = userListAdapter
            swipeRefresh.setOnRefreshListener {
                lifecycleScope.launch(exceptionHandler) {
                    viewModel.updateUsers()
                    userListAdapter.submitList(viewModel.getUsers())
                    swipeRefresh.isRefreshing = false
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}