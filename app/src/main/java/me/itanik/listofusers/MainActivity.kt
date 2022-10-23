package me.itanik.listofusers

import android.os.Bundle
import android.text.Html
import android.text.Html.FROM_HTML_MODE_LEGACY
import android.text.Spanned
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<TextView>(R.id.userName).text = "User"
        findViewById<TextView>(R.id.userEmail).text = "user@email.com"
        findViewById<TextView>(R.id.userPhone).text =
            formatHtml(R.string.phone_html_ph, "8800553535")
        findViewById<TextView>(R.id.userAge).text = formatHtml(R.string.age_html_ph, "33")
        findViewById<TextView>(R.id.userAddress).text =
            formatHtml(R.string.address_html_ph, "address")
        findViewById<TextView>(R.id.userCompany).text =
            formatHtml(R.string.company_html_ph, "Company Inc.")
        findViewById<TextView>(R.id.userRegistered).text =
            formatHtml(R.string.registered_html_ph, "23.10.2022")
        findViewById<TextView>(R.id.userAbout).text = formatHtml(
            R.string.about_html_ph,
            "Lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum lorem ipsum"
        )
        findViewById<ImageView>(R.id.userFavoriteFruit).setImageResource(R.drawable.ic_apple)
        findViewById<ImageView>(R.id.userEyeColor).setImageResource(R.drawable.ic_green_circle)
    }

    private fun formatHtml(res: Int, s: String): Spanned {
        val formattedString = getString(res, s)
        return Html.fromHtml(formattedString, FROM_HTML_MODE_LEGACY)
    }
}