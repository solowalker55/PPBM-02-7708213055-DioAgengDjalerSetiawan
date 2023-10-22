package com.dioageng.flane

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class LogIn : AppCompatActivity() {
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

        setContentView(R.layout.log_in)

        val goToSignUp = findViewById<TextView>(R.id.login_signUp)
        goToSignUp.setOnClickListener{
            val Intent = Intent(this, SignUp::class.java)
            startActivity(Intent)
        }

        val goToHome = findViewById<Button>(R.id.login_login)
        goToHome.setOnClickListener{
            val Intent = Intent(this, Home::class.java)
            startActivity(Intent)
        }

        val goToReset = findViewById<TextView>(R.id.login_forgot)
        goToReset.setOnClickListener{
            val Intent = Intent(this, ForgotPass::class.java)
            startActivity(Intent)
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}