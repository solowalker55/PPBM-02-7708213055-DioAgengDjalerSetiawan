package com.dioageng.flane

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import androidx.cardview.widget.CardView

class PaymentMethod : AppCompatActivity() {
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

        setContentView(R.layout.activity_payment_method)

        val gotohome = findViewById<ImageView>(R.id.payment_toHome)
        gotohome.setOnClickListener{showCancelConfirmationDialog()
        }

        val gotonot= findViewById<CardView>(R.id.payment_toNot)
        gotonot.setOnClickListener{
            val Intent = Intent(this, NotImplemented::class.java)
            startActivity(Intent)
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showCancelConfirmationDialog()
            return true // Back key event consumed
        }
        return super.onKeyDown(keyCode, event)
    }

    private fun showCancelConfirmationDialog() {
        val dialogBuilder = AlertDialog.Builder(this)

        dialogBuilder.setMessage("Are you sure to cancel this?")
            .setCancelable(false)
            .setPositiveButton("Yes") { _, _ ->
                // User clicked "Yes," navigate to Home activity
                // Replace 'HomeActivity' with the actual name of your home activity
                val intent = Intent(this, Home::class.java)
                startActivity(intent)
            }
            .setNegativeButton("No") { dialog, _ ->
                // User clicked "No," dismiss the dialog
                dialog.dismiss()
            }

        val alert = dialogBuilder.create()
        alert.show()
    }
}