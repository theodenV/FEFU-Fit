package ru.fefu.fefufit

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ru.fefu.fefufit.data.ActivityEntity
import ru.fefu.fefufit.data.ActivityType
import ru.fefu.fefufit.data.AppDatabase

class StartActivity : AppCompatActivity() {
    private var currentType: ActivityTypeUi? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

        setupActivityTypeRecycler()
        setupStartButton()
    }

    private fun setupActivityTypeRecycler() {
        val typeRecycler = findViewById<RecyclerView>(R.id.activityTypeRecycler)
        val activityTypes = listOf(
            ActivityTypeUi("Велосипед", R.mipmap.ic_bicycle_activity),
            ActivityTypeUi("Бег", R.mipmap.ic_run_activity),
            ActivityTypeUi("Шаг", R.mipmap.ic_walk_activity)
        )
        val typeAdapter = ActivityTypeAdapter(activityTypes) { currentType = it }
        typeRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        typeRecycler.adapter = typeAdapter
        currentType = activityTypes.first()
    }

    private fun setupStartButton() {
        val startButton = findViewById<Button>(R.id.buttonStart)
        startButton.setOnClickListener {
            val selectedActivityType = when (currentType?.title) {
                "Велосипед" -> ActivityType.Велосипед
                "Бег" -> ActivityType.Бег
                else -> ActivityType.Ходьба
            }
            val startTime = System.currentTimeMillis()
            val endTime = startTime + (10..60).random() * 60 * 1000L
            val locationData = listOf(
                Pair(43.1 + Math.random(), 131.9 + Math.random()),
                Pair(43.2 + Math.random(), 132.0 + Math.random())
            )
            val locationString = locationData.joinToString(";") { "${it.first},${it.second}" }
            val database = AppDatabase.getInstance(this)
            CoroutineScope(Dispatchers.IO).launch {
                database.activityDao().insert(
                    ActivityEntity(
                        activityType = selectedActivityType,
                        startTime = startTime,
                        endTime = endTime,
                        locationData = locationString
                    )
                )
            }
            val progressIntent = Intent(this, ActivityInProgressActivity::class.java)
            progressIntent.putExtra("type", currentType?.title)
            startActivity(progressIntent)
        }
    }
} 