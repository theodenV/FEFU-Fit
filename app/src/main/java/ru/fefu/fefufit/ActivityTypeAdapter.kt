package ru.fefu.fefufit

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ActivityTypeAdapter(private val typeList: List<ActivityTypeUi>, private val onTypeSelected: (ActivityTypeUi) -> Unit) : RecyclerView.Adapter<ActivityTypeAdapter.ViewHolder>() {
    private var currentSelection = 0

    override fun getItemCount(): Int = typeList.size

    override fun onBindViewHolder(holder: ViewHolder, @SuppressLint("RecyclerView") position: Int) {
        val currentType = typeList[position]
        holder.typeTitle.text = currentType.title
        holder.typeIcon.setImageResource(currentType.iconRes)
        holder.itemView.isSelected = position == currentSelection
        holder.itemView.setBackgroundResource(
            if (position == currentSelection)
                R.drawable.bg_activity_type_item_selected
            else
                R.drawable.bg_activity_type_item_unselected
        )
        val layoutParams = holder.itemView.layoutParams as ViewGroup.MarginLayoutParams
        layoutParams.marginStart = if (position == 0) 0 else holder.itemView.context.resources.displayMetrics.density.times(4).toInt()
        holder.itemView.layoutParams = layoutParams
        holder.itemView.setOnClickListener {
            val previousSelection = currentSelection
            currentSelection = position
            notifyItemChanged(previousSelection)
            notifyItemChanged(position)
            onTypeSelected(currentType)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_activity_type, parent, false)
        return ViewHolder(itemView)
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val typeIcon: ImageView = view.findViewById(R.id.icon)
        val typeTitle: TextView = view.findViewById(R.id.title)
    }
}

class ActivityTypeUi(val title: String, val iconRes: Int) 