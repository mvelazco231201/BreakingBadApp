package com.example.breakingbadapp.activities.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.breakingbadapp.R
import com.example.breakingbadapp.activities.models.Phrase
import com.example.breakingbadapp.activities.viewModel.PhraseViewModel
import com.example.breakingbadapp.databinding.FragmentPhraseBinding

class PhraseFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val phraseViewModel = ViewModelProvider(this).get(PhraseViewModel::class.java)
        val binding = FragmentPhraseBinding.inflate(inflater, container, false)

        phraseViewModel.phrases.observe(viewLifecycleOwner, Observer<MutableList<Phrase>>{
            phrase ->

            binding.quote.text = phrase[0].quote
            binding.author.text = phrase[0].author
        })

        binding.root.setOnClickListener(){
            phraseViewModel.fetchInfo()
        }

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        val phraseViewModel = ViewModelProvider(this).get(PhraseViewModel::class.java)
        phraseViewModel.fetchInfo()
    }
}