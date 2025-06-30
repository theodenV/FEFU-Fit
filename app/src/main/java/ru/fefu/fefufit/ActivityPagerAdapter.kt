package ru.fefu.fefufit

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ActivityPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Tab1Fragment.newInstance()
            else -> Tab2Fragment.newInstance()
        }
    }

    override fun getItemCount(): Int = 2
}