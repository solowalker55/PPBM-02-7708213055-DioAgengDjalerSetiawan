package com.dioageng.flane

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import de.hdodenhof.circleimageview.CircleImageView

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        val decorView: View = window.decorView
        decorView.systemUiVisibility = (
                View.SYSTEM_UI_FLAG_IMMERSIVE
                        or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        or View.SYSTEM_UI_FLAG_FULLSCREEN
                )

        setContentView(R.layout.profile)

        val goToHome = findViewById<ImageView>(R.id.profile_toHome)
        goToHome.setOnClickListener{
            val Intent = Intent(this, Home::class.java)
            startActivity(Intent)
        }

        val gotoaccount = findViewById<CardView>(R.id.profile_account)
        gotoaccount.setOnClickListener{
            val Intent = Intent(this, ProfileAccount::class.java)
            startActivity(Intent)
        }

        val gotosecurity = findViewById<CardView>(R.id.profile_secutiry)
        gotosecurity.setOnClickListener{
            val Intent = Intent(this, ProfileSecurity::class.java)
            startActivity(Intent)
        }

        val gotogeograph = findViewById<CardView>(R.id.profile_geograph)
        gotogeograph.setOnClickListener{
            val Intent = Intent(this, ProfileGeograp::class.java)
            startActivity(Intent)
        }

        val gotorecent = findViewById<CardView>(R.id.profile_recent)
        gotorecent.setOnClickListener{
            val Intent = Intent(this, ProfileRecent::class.java)
            startActivity(Intent)
        }

        val gotopayment = findViewById<CardView>(R.id.profile_payment)
        gotopayment.setOnClickListener{
            val Intent = Intent(this, ProfilePayment::class.java)
            startActivity(Intent)
        }

        val gotoaccessibility = findViewById<CardView>(R.id.profile_accessibility)
        gotoaccessibility.setOnClickListener{
            val Intent = Intent(this, ProfileAccessibility::class.java)
            startActivity(Intent)
        }

        val gotosettings = findViewById<CardView>(R.id.profile_settings)
        gotosettings.setOnClickListener{
            val Intent = Intent(this, ProfileSettings::class.java)
            startActivity(Intent)
        }

        val goToAbout = findViewById<CardView>(R.id.profile_toAbout)
        goToAbout.setOnClickListener{
            val Intent = Intent(this, About::class.java)
            startActivity(Intent)
        }

        lateinit var ratingBar: RatingBar
        lateinit var commentTextView: TextView

        ratingBar = findViewById(R.id.profile_ratingBar)
        commentTextView = findViewById(R.id.about_comment)

        // Set an OnRatingBarChangeListener
        ratingBar.setOnRatingBarChangeListener { _, rating, _ ->
            val comment = when (rating.toInt()) {
                1 -> "Why?, can you give advice?"
                2 -> "Is there any problems?"
                3 -> "Thanks, How can I improve more?"
                4 -> "Glad to hear that !!"
                5 -> "Wow, what makes you?"
                else -> ""
            }

            // Update the comment TextView
            commentTextView.text = comment
        }
    }

    override fun onBackPressed() {
        // Start the desired activity when the back button is pressed
        val intent = Intent(this, Home::class.java)
        startActivity(intent)
    }
}