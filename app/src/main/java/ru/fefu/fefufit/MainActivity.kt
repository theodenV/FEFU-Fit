package ru.fefu.fefufit

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        
        setupSignInButton()
        setupSignUpButton()
    }

    private fun setupSignInButton() {
        val signInButton = findViewById<Button>(R.id.loginButton)
        signInButton.setOnClickListener {
            val loginIntent = Intent(this, LoginActivity::class.java)
            startActivity(loginIntent)
        }
    }

    private fun setupSignUpButton() {
        val signUpButton = findViewById<Button>(R.id.registerButton)
        signUpButton.setOnClickListener {
            val registrationIntent = Intent(this, RegistrationActivity::class.java)
            startActivity(registrationIntent)
        }
    }
}
