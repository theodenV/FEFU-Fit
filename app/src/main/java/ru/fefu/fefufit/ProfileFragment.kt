package ru.fefu.fefufit

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment() {
    
    companion object {
        fun newInstance() = ProfileFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupPasswordButton(view)
        setupLogoutButton(view)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_profile, container, false)
    }

    private fun setupPasswordButton(parentView: View) {
        val passwordButton = parentView.findViewById<Button>(R.id.ButtonChangePassword)
        passwordButton.setOnClickListener {
            val passwordIntent = Intent(requireContext(), ChangePasswordActivity::class.java)
            startActivity(passwordIntent)
        }
    }

    private fun setupLogoutButton(parentView: View) {
        val logoutButton = parentView.findViewById<Button>(R.id.buttonLogout)
        logoutButton.setOnClickListener {
            val mainIntent = Intent(requireContext(), MainActivity::class.java)
            startActivity(mainIntent)
        }
    }
}