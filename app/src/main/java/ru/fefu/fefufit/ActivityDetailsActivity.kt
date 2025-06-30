package ru.fefu.fefufit

import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class ActivityDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setupToolbar()
        initializeViews()
        loadActivityData()
    }

    private fun setupToolbar() {
        val navigationBar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(navigationBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigationBar.setNavigationOnClickListener { finish() }
    }

    private fun initializeViews() {
        val distanceLabel = findViewById<TextView>(R.id.tvDistance)
        val timeLabel = findViewById<TextView>(R.id.tvAgo)
        val durationLabel = findViewById<TextView>(R.id.tvDuration)
        val startLabel = findViewById<TextView>(R.id.tvStart)
        val finishLabel = findViewById<TextView>(R.id.tvFinish)
        val commentField = findViewById<EditText>(R.id.etComment)
    }

    private fun loadActivityData() {
        val distanceLabel = findViewById<TextView>(R.id.tvDistance)
        val timeLabel = findViewById<TextView>(R.id.tvAgo)
        val durationLabel = findViewById<TextView>(R.id.tvDuration)
        val startLabel = findViewById<TextView>(R.id.tvStart)
        val finishLabel = findViewById<TextView>(R.id.tvFinish)
        val commentField = findViewById<EditText>(R.id.etComment)

        distanceLabel.text = intent.getStringExtra("distance")
        timeLabel.text = intent.getStringExtra("ago")
        durationLabel.text = intent.getStringExtra("duration")
        startLabel.text = intent.getStringExtra("start")
        finishLabel.text = intent.getStringExtra("finish")
        commentField.setText(intent.getStringExtra("comment") ?: "")
    }
} 