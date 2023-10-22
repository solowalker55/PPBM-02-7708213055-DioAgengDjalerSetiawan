package com.dioageng.flane

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.AdapterView
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SignUp : AppCompatActivity() {
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

        setContentView(R.layout.sign_up)

        var jobSpinner = findViewById<Spinner>(R.id.spinnerjobs)

        // Create an ArrayAdapter with the job items
        val jobs = resources.getStringArray(R.array.jobs)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, jobs)

        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        // Apply the adapter to the spinner
        jobSpinner.adapter = adapter

        // Set an item selected listener to respond to user selections
        jobSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString()
                // Handle the selected item (e.g., show a toast message)
                Toast.makeText(this@SignUp, "Selected job: $selectedItem", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

        val goToLogIn = findViewById<Button>(R.id.signUpBtn)
        goToLogIn.setOnClickListener{
            val Intent = Intent(this, LogIn::class.java)
            startActivity(Intent)
        }

        val goToLgin1 = findViewById<TextView>(R.id.signup_login)
        goToLgin1.setOnClickListener{
            val Intent = Intent(this, LogIn::class.java)
            startActivity(Intent)
        }
    }

    override fun onBackPressed() {
        finishAffinity()
    }
}