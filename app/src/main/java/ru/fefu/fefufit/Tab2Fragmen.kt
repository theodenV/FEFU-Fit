package ru.fefu.fefufit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Tab2Fragment : Fragment() {
    
    companion object {
        fun newInstance() = Tab2Fragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView = inflater.inflate(R.layout.fragment_tab2, container, false)
        val userActivityRecycler = fragmentView.findViewById<RecyclerView>(R.id.recyclerView)
        userActivityRecycler.layoutManager = LinearLayoutManager(requireContext())
        userActivityRecycler.adapter = ActivityAdapter(generateUserActivities())
        return fragmentView
    }

    private fun generateUserActivities(): List<ActivityItem> {
        return listOf(
            ActivityItem(
                distance = "14.32 км",
                duration = "2 часа 46 минут",
                type = "Серфинг",
                date = "14 часов назад",
                nickname = "@nevergonna"
            ),
            ActivityItem(
                distance = "567 м",
                duration = "10 минут",
                type = "Велосипед",
                date = "29.05.2022",
                nickname = "@giveyou_up"
            ),
            ActivityItem(
                distance = "5 км",
                duration = "40 минут",
                type = "Бег",
                date = "31.08.2023",
                nickname = "@rickroll"
            )
        )
    }
}

data class ActivityItem(
    val distance: String,
    val duration: String,
    val type: String,
    val date: String,
    val nickname: String
)