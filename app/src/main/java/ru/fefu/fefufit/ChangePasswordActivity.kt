package ru.fefu.fefufit

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ChangePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        setupNavigationBar()
        initializeAcceptButton()
    }

    private fun setupNavigationBar() {
        val navigationBar = findViewById<Toolbar>(R.id.toolBar)
        setSupportActionBar(navigationBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationBar.setNavigationOnClickListener { finish() }
    }

    private fun initializeAcceptButton() {
        val acceptButton = findViewById<Button>(R.id.buttonAccept)
    }
} 