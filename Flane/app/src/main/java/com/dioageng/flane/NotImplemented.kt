package com.dioageng.flane

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.cardview.widget.CardView

class NotImplemented : AppCompatActivity() {
    private val splashTimeOut: Long = 3000
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

        setContentView(R.layout.not_implemented)

        Handler().postDelayed({
            // Start the SignUpActivity after the delay
            val intent = Intent(this, Home::class.java)
            startActivity(intent)
            finish() // Close the splash screen (MainActivity)
        }, splashTimeOut)

        // Find your CardView by its ID
        val cardView = findViewById<CardView>(R.id.not_spawnCard)

        // Hide the CardView initially
        cardView.visibility = View.GONE

        // Schedule a task to make the CardView visible after 4 seconds
        Handler(Looper.getMainLooper()).postDelayed({
            cardView.visibility = View.VISIBLE
        }, 2500) // 4000 milliseconds = 4 seconds
    }

    override fun onBackPressed() {
    }
}