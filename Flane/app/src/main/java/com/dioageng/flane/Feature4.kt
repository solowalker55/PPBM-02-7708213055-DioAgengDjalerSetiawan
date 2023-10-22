package com.dioageng.flane

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout

class Feature4 : AppCompatActivity() {
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

        setContentView(R.layout.feature4)

        val goToHome = findViewById<ImageView>(R.id.feature4_back)
        goToHome.setOnClickListener{
            val Intent = Intent(this, Home::class.java)
            startActivity(Intent)
        }

        val gotoproduct1 = findViewById<LinearLayout>(R.id.feature4_widget)
        gotoproduct1.setOnClickListener{
            val Intent = Intent(this, ProductDetail::class.java)
            startActivity(Intent)
        }
    }

    override fun onBackPressed() {
        // Start the desired activity when the back button is pressed
        val intent = Intent(this, Home::class.java)
        startActivity(intent)
    }
}