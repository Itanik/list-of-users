package me.itanik.listofusers.ui.user_details

import android.annotation.SuppressLint
import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.launch
import me.itanik.listofusers.R
import me.itanik.listofusers.data.network.dto.EyeColor
import me.itanik.listofusers.data.network.dto.FavoriteFruit
import me.itanik.listofusers.databinding.FragmentUserDetailsBinding
import me.itanik.listofusers.ui.NavArguments
import me.itanik.listofusers.ui.user_list.UserListAdapter
import java.text.SimpleDateFormat
import java.util.*

class UserDetailsFragment : Fragment() {
    private var _binding: FragmentUserDetailsBinding? = null
    private val binding: FragmentUserDetailsBinding get() = _binding!!
    private val viewModel: UserDetailsViewModel by viewModels()

    private val userId: Int
        get() = arguments?.getInt(NavArguments.USER_ID)
            ?: throw Exception("User id is not specified")

    private val userListAdapter = UserListAdapter { user ->
        if (user.isActive)
            findNavController().navigate(R.id.action_userDetailsFragment_self, Bundle().apply {
                putInt(NavArguments.USER_ID, user.id)
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        lifecycleScope.launch {
            val user = viewModel.getUser(userId)
            with(binding) {
                userName.text = user.name
                userEmail.text = user.email
                userPhone.text = formatHtml(R.string.phone_html_ph, user.phone)
                userAge.text = formatHtml(R.string.age_html_ph, user.age.toString())
                userAddress.text = formatHtml(R.string.address_html_ph, user.address)
                userCompany.text = formatHtml(R.string.company_html_ph, user.company)
                userRegistered.text =
                    formatHtml(R.string.registered_html_ph, formatDate(user.registered))
                userAbout.text = formatHtml(R.string.about_html_ph, user.about)
                userFavoriteFruit.setImageResource(
                    when (user.favoriteFruit) {
                        FavoriteFruit.APPLE -> R.drawable.ic_apple
                        FavoriteFruit.BANANA -> R.drawable.ic_banana
                        FavoriteFruit.STRAWBERRY -> R.drawable.ic_strawberry
                    }
                )
                userEyeColor.setImageResource(
                    when (user.eyeColor) {
                        EyeColor.GREEN -> R.drawable.ic_green_circle
                        EyeColor.BROWN -> R.drawable.ic_brown_circle
                        EyeColor.BLUE -> R.drawable.ic_blue_circle
                    }
                )
                userLatLong.text =
                    formatHtml(R.string.lat_lon_html_ph, "${user.latitude} ${user.longitude}")
                friendsListRv.adapter = userListAdapter
                userListAdapter.submitList(viewModel.getFriends(user))
            }
        }
    }

    @SuppressLint("SimpleDateFormat")
    private fun formatDate(date: Date): String {
        return SimpleDateFormat().run {
            applyPattern("H:mm dd.MM.yy")
            format(date)
        }
    }

    private fun formatHtml(res: Int, s: String): Spanned {
        val formattedString = getString(res, s)
        return Html.fromHtml(formattedString, Html.FROM_HTML_MODE_LEGACY)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}