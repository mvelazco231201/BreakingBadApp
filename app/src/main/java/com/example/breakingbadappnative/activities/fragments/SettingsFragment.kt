package com.example.breakingbadapp.activities.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.breakingbadapp.activities.main.MainActivity
import com.example.breakingbadapp.databinding.FragmentSettingsBinding



class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentSettingsBinding.inflate(inflater, container, false)
        binding.button2.setOnClickListener(){
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
    }

