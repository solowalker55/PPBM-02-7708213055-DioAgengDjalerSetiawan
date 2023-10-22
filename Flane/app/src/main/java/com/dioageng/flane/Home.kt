package com.dioageng.flane

import android.content.Intent
import android.media.Image.Plane
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import de.hdodenhof.circleimageview.CircleImageView

class Home : AppCompatActivity() {

    private var backPressedTime: Long = 0
    private val threshold: Long = 700

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

        setContentView(R.layout.home)
        // To go to Profile
        val goToProfile = findViewById<CircleImageView>(R.id.home_profile)
        goToProfile.setOnClickListener{
            val Intent = Intent(this, Profile::class.java)
            startActivity(Intent)
        }
        // To go to Hotel Feature1
        val goToHotel = findViewById<LinearLayout>(R.id.home_toHotel)
        goToHotel.setOnClickListener{
            val Intent = Intent(this, Feature1::class.java)
            startActivity(Intent)
        }
        // To go to Plane Feature2
        val goToPlane = findViewById<LinearLayout>(R.id.home_toPlane)
        goToPlane.setOnClickListener{
            val Intent = Intent(this, Feature2::class.java)
            startActivity(Intent)
        }
        // To go to Train Feature3
        val goToTrain = findViewById<LinearLayout>(R.id.home_toTrain)
        goToTrain.setOnClickListener{
            val Intent = Intent(this, Feature3::class.java)
            startActivity(Intent)
        }
        // To go to Bus Feature4
        val goToBus = findViewById<LinearLayout>(R.id.home_toBus)
        goToBus.setOnClickListener{
            val Intent = Intent(this, Feature4::class.java)
            startActivity(Intent)
        }
        // To go to Not Implemented Widget
        val goToPruduct1 = findViewById<LinearLayout>(R.id.home_hvWidzet1)
        goToPruduct1.setOnClickListener{
            val Intent = Intent(this, ProductDetail::class.java)
            startActivity(Intent)
        }
        // To go to Not Implemented Widget
        val goToProduct2 = findViewById<LinearLayout>(R.id.home_hvWidzet2)
        goToProduct2.setOnClickListener{
            val Intent = Intent(this, ProductDetail::class.java)
            startActivity(Intent)
        }
        // To go to Not Implemented Widget
        val goToProduct3 = findViewById<LinearLayout>(R.id.home_hvWidzet3)
        goToProduct3.setOnClickListener{
            val Intent = Intent(this, ProductDetail::class.java)
            startActivity(Intent)
        }
        // To go to Not Implemented Widget
        val goToProduct4 = findViewById<LinearLayout>(R.id.home_hvWidzet4)
        goToProduct4.setOnClickListener{
            val Intent = Intent(this, ProductDetail::class.java)
            startActivity(Intent)
        }
    }

    override fun onBackPressed() {
        if (backPressedTime + threshold > System.currentTimeMillis()) {
            // Exit the app when the back button is pressed twice within the threshold
            finishAffinity()
        } else {
            // Inform the user to press the back button again to exit
            Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show()
            backPressedTime = System.currentTimeMillis()
        }
    }
}