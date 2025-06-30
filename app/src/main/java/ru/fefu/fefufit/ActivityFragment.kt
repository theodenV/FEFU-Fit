package ru.fefu.fefufit

import android.content.Intent
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class ActivityFragment : Fragment() {
    
    companion object {
        fun newInstance() = ActivityFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupTabLayout(view)
        setupFloatingButton(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_activity, container, false)
    }

    private fun setupTabLayout(parentView: View) {
        val tabContainer = parentView.findViewById<TabLayout>(R.id.tab_layout)
        val pagerContainer = parentView.findViewById<ViewPager2>(R.id.view_pager)
        pagerContainer.adapter = ActivityPagerAdapter(this)

        TabLayoutMediator(tabContainer, pagerContainer) { tab, position ->
            tab.text = when (position) {
                0 -> "Мои"
                else -> "Пользователей"
            }
        }.attach()
    }

    private fun setupFloatingButton(parentView: View) {
        val addButton = parentView.findViewById<FloatingActionButton>(R.id.fab_add_activity)
        addButton.setOnClickListener {
            startActivity(Intent(requireContext(), StartActivity::class.java))
        }
    }
}