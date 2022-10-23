package me.itanik.listofusers.ui.user_details

import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.itanik.listofusers.R
import me.itanik.listofusers.databinding.FragmentUserDetailsBinding

class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {
    private var _binding: FragmentUserDetailsBinding? = null
    private val binding: FragmentUserDetailsBinding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        with(binding) {
            userName.text = "User"
            userEmail.text = "user@email.com"
            userPhone.text = formatHtml(R.string.phone_html_ph, "8800553535")
            userAge.text = formatHtml(R.string.age_html_ph, "33")
            userAddress.text = formatHtml(R.string.address_html_ph, "address")
            userCompany.text = formatHtml(R.string.company_html_ph, "Company Inc.")
            userRegistered.text = formatHtml(R.string.registered_html_ph, "23.10.2022")
            userAbout.text = formatHtml(
                R.string.about_html_ph,
                "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum"
            )
            userFavoriteFruit.setImageResource(R.drawable.ic_apple)
            userEyeColor.setImageResource(R.drawable.ic_green_circle)
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