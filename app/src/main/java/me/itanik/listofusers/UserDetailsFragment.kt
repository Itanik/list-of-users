package me.itanik.listofusers

import android.os.Bundle
import android.text.Html
import android.text.Spanned
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.userName).text = "User"
        view.findViewById<TextView>(R.id.userEmail).text = "user@email.com"
        view.findViewById<TextView>(R.id.userPhone).text =
            formatHtml(R.string.phone_html_ph, "8800553535")
        view.findViewById<TextView>(R.id.userAge).text = formatHtml(R.string.age_html_ph, "33")
        view.findViewById<TextView>(R.id.userAddress).text =
            formatHtml(R.string.address_html_ph, "address")
        view.findViewById<TextView>(R.id.userCompany).text =
            formatHtml(R.string.company_html_ph, "Company Inc.")
        view.findViewById<TextView>(R.id.userRegistered).text =
            formatHtml(R.string.registered_html_ph, "23.10.2022")
        view.findViewById<TextView>(R.id.userAbout).text = formatHtml(
            R.string.about_html_ph,
            "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum"
        )
        view.findViewById<ImageView>(R.id.userFavoriteFruit).setImageResource(R.drawable.ic_apple)
        view.findViewById<ImageView>(R.id.userEyeColor).setImageResource(R.drawable.ic_green_circle)
    }

    private fun formatHtml(res: Int, s: String): Spanned {
        val formattedString = getString(res, s)
        return Html.fromHtml(formattedString, Html.FROM_HTML_MODE_LEGACY)
    }
}