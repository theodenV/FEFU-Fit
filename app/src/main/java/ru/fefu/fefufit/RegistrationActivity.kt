package ru.fefu.fefufit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout

class RegistrationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_activity)
        
        setupNavigationBar()
        setupRegistrationButton()
    }

    private fun setupNavigationBar() {
        val appBar = findViewById<AppBarLayout>(R.id.AppBar)
        val toolbar = appBar.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolBar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    private fun setupRegistrationButton() {
        val signUpButton = findViewById<Button>(R.id.registerButton)
        signUpButton.setOnClickListener {
            val mainIntent = Intent(this, EmptystateActivity::class.java)
            startActivity(mainIntent)
        }
    }
}