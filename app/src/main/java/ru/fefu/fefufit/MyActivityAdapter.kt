package ru.fefu.fefufit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.fefufit.data.ActivityEntity
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

class MyActivityAdapter(private var activityData: List<ActivityEntity>) : RecyclerView.Adapter<MyActivityAdapter.MyActivityViewHolder>() {
    
    override fun getItemCount(): Int = activityData.size

    fun refreshData(newActivityData: List<ActivityEntity>) {
        activityData = newActivityData
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MyActivityViewHolder, position: Int) {
        val currentActivity = activityData[position]
        holder.updateView(currentActivity)
        holder.itemView.setOnClickListener {
            val parentContext = holder.itemView.context
            val selectedActivity = activityData[position]
            val detailsIntent = Intent(parentContext, ActivityDetailsActivity::class.java)
            detailsIntent.putExtra("distance", "-")
            detailsIntent.putExtra("ago", formatAgo(selectedActivity.endTime))
            detailsIntent.putExtra("duration", holder.formatTimeDuration(selectedActivity.endTime - selectedActivity.startTime))
            detailsIntent.putExtra("start", formatDate(selectedActivity.startTime))
            detailsIntent.putExtra("finish", formatDate(selectedActivity.endTime))
            detailsIntent.putExtra("comment", "")
            parentContext.startActivity(detailsIntent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyActivityViewHolder {
        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.my_activity_item, parent, false)
        return MyActivityViewHolder(itemLayout)
    }

    class MyActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val distanceLabel: TextView = itemView.findViewById(R.id.tvDistance)
        private val timeLabel: TextView = itemView.findViewById(R.id.tvDuration)
        private val typeLabel: TextView = itemView.findViewById(R.id.tvType)
        private val dateLabel: TextView = itemView.findViewById(R.id.tvDate)

        fun updateView(activity: ActivityEntity) {
            distanceLabel.text = "-"
            timeLabel.text = formatTimeDuration(activity.endTime - activity.startTime)
            typeLabel.text = activity.activityType.name
            dateLabel.text = formatAgo(activity.endTime)
        }

        fun formatTimeDuration(durationMs: Long): String {
            val totalSeconds = durationMs / 1000
            val minutes = totalSeconds / 60
            val seconds = totalSeconds % 60
            return String.format("%d:%02d", minutes, seconds)
        }
    }
}

fun formatAgo(timeMs: Long): String {
    val currentTime = System.currentTimeMillis()
    val timeDifference = currentTime - timeMs
    val minutes = TimeUnit.MILLISECONDS.toMinutes(timeDifference)
    val hours = TimeUnit.MILLISECONDS.toHours(timeDifference)
    val days = TimeUnit.MILLISECONDS.toDays(timeDifference)
    return when {
        days > 0 -> SimpleDateFormat("dd.MM.yyyy", Locale.getDefault()).format(Date(timeMs))
        hours > 0 -> "$hours часов назад"
        minutes > 0 -> "$minutes минут назад"
        else -> "только что"
    }
}

fun formatDate(timeMs: Long): String {
    return SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault()).format(Date(timeMs))
} 