package ru.fefu.fefufit

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ActivityInProgressActivity : AppCompatActivity() {
    private var isRunning = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_in_progress)

        setupActivityInfo()
        setupControlButton()
    }

    private fun setupActivityInfo() {
        val activityType = intent.getStringExtra("type") ?: "Велосипед"
        val typeLabel = findViewById<TextView>(R.id.activityType)
        typeLabel.text = activityType
        
        val distanceLabel = findViewById<TextView>(R.id.distance)
        distanceLabel.text = "14 км"
        
        val timeLabel = findViewById<TextView>(R.id.time)
        timeLabel.text = "00:01:46"
    }

    private fun setupControlButton() {
        val controlButton = findViewById<FloatingActionButton>(R.id.buttonStop)
        controlButton.setOnClickListener {
            isRunning = !isRunning
            if (isRunning) {
                controlButton.setImageResource(R.drawable.ic_pause)
            } else {
                controlButton.setImageResource(R.drawable.ic_play)
            }
        }
    }
}