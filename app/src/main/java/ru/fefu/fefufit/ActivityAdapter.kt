package ru.fefu.fefufit

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivityAdapter(private val activityList: List<ActivityItem>) : RecyclerView.Adapter<ActivityAdapter.ActivityViewHolder>() {
    
    override fun getItemCount(): Int = activityList.size

    override fun onBindViewHolder(holder: ActivityViewHolder, position: Int) {
        val currentItem = activityList[position]
        holder.updateView(currentItem)
        holder.itemView.setOnClickListener {
            val parentContext = holder.itemView.context
            val selectedItem = activityList[position]
            val detailsIntent = Intent(parentContext, ActivityDetailsActivity::class.java)
            detailsIntent.putExtra("distance", selectedItem.distance)
            detailsIntent.putExtra("ago", selectedItem.date)
            detailsIntent.putExtra("duration", selectedItem.duration)
            detailsIntent.putExtra("start", "00:00")
            detailsIntent.putExtra("finish", "00:00")
            detailsIntent.putExtra("comment", "")
            parentContext.startActivity(detailsIntent)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActivityViewHolder {
        val itemLayout = LayoutInflater.from(parent.context).inflate(R.layout.activity_item, parent, false)
        return ActivityViewHolder(itemLayout)
    }

    class ActivityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val distanceText: TextView = itemView.findViewById(R.id.tvDistance)
        private val timeText: TextView = itemView.findViewById(R.id.tvDuration)
        private val activityTypeText: TextView = itemView.findViewById(R.id.tvType)
        private val dateText: TextView = itemView.findViewById(R.id.tvDate)
        private val userText: TextView = itemView.findViewById(R.id.tvNickname)

        fun updateView(activityData: ActivityItem) {
            distanceText.text = activityData.distance
            timeText.text = activityData.duration
            activityTypeText.text = activityData.type
            dateText.text = activityData.date
            userText.text = activityData.nickname
        }
    }
} 