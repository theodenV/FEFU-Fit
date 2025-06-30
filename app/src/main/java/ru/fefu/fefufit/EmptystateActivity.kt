package ru.fefu.fefufit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class EmptystateActivity : AppCompatActivity() {
    private lateinit var navigationView: BottomNavigationView
    private val activityFragmentTag = "ACTIVITY_FRAGMENT"
    private val profileFragmentTag = "PROFILE_FRAGMENT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.emptystate_activity)

        navigationView = findViewById(R.id.bottom_nav)

        if (savedInstanceState == null) {
            showActivityFragment()
        }

        setupNavigationListener()
    }

    private fun setupNavigationListener() {
        navigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_activity -> {
                    showActivityFragment()
                    true
                }
                R.id.nav_profile -> {
                    showProfileFragment()
                    true
                }
                else -> false
            }
        }
    }

    private fun showActivityFragment() {
        val activityFragment = supportFragmentManager.findFragmentByTag(activityFragmentTag)
                as? ActivityFragment ?: ActivityFragment.newInstance()

        supportFragmentManager.beginTransaction().apply {
            supportFragmentManager.findFragmentByTag(profileFragmentTag)?.let { hide(it) }
            if (activityFragment.isAdded) {
                show(activityFragment)
            } else {
                add(R.id.fragment_container, activityFragment, activityFragmentTag)
            }
        }.commit()
    }

    private fun showProfileFragment() {
        val profileFragment = supportFragmentManager.findFragmentByTag(profileFragmentTag)
                as? ProfileFragment ?: ProfileFragment.newInstance()

        supportFragmentManager.beginTransaction().apply {
            supportFragmentManager.findFragmentByTag(activityFragmentTag)?.let { hide(it) }
            if (profileFragment.isAdded) {
                show(profileFragment)
            } else {
                add(R.id.fragment_container, profileFragment, profileFragmentTag)
            }
        }.commit()
    }
}