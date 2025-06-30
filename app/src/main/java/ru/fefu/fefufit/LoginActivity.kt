package ru.fefu.fefufit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        
        setupNavigationBar()
        setupLoginButton()
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

    private fun setupLoginButton() {
        val signInButton = findViewById<Button>(R.id.loginButton)
        signInButton.setOnClickListener {
            val mainIntent = Intent(this, EmptystateActivity::class.java)
            startActivity(mainIntent)
        }
    }
}

