package ru.fefu.fefufit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.fefu.fefufit.data.AppDatabase

class Tab1Fragment : Fragment() {
    private lateinit var activityAdapter: MyActivityAdapter
    private var emptyStateLayout: LinearLayout? = null
    private var activityRecycler: RecyclerView? = null

    companion object {
        fun newInstance() = Tab1Fragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadActivityData()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentView = inflater.inflate(R.layout.fragment_tab1, container, false)
        activityRecycler = fragmentView.findViewById(R.id.recyclerView)
        emptyStateLayout = fragmentView.findViewById(R.id.emptyStateLayout)
        activityRecycler?.layoutManager = LinearLayoutManager(requireContext())
        activityAdapter = MyActivityAdapter(emptyList())
        activityRecycler?.adapter = activityAdapter
        return fragmentView
    }

    private fun loadActivityData() {
        val database = AppDatabase.getInstance(requireContext())
        database.activityDao().getAll().observe(viewLifecycleOwner) { activityList ->
            activityAdapter.refreshData(activityList)
            if (activityList.isNullOrEmpty()) {
                emptyStateLayout?.visibility = View.VISIBLE
                activityRecycler?.visibility = View.GONE
            } else {
                emptyStateLayout?.visibility = View.GONE
                activityRecycler?.visibility = View.VISIBLE
            }
        }
    }
}

data class MyActivityItem(
    val distance: String,
    val duration: String,
    val type: String,
    val icon: String,
    val date: String
)