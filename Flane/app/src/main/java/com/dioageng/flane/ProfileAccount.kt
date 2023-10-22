package com.dioageng.flane

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView

class ProfileAccount : AppCompatActivity() {
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

        setContentView(R.layout.activity_profile_account)

        val gotoprofile = findViewById<ImageView>(R.id.paccount_profile)
        gotoprofile.setOnClickListener{
            val Intent = Intent(this, Profile::class.java)
            startActivity(Intent)
        }

        val gotonot = findViewById<LinearLayout>(R.id.paccount_not)
        gotonot.setOnClickListener{
            val Intent = Intent(this, NotImplemented::class.java)
            startActivity(Intent)
        }
    }

    override fun onBackPressed() {
        // Start the desired activity when the back button is pressed
        val intent = Intent(this, Profile::class.java)
        startActivity(intent)
    }
}