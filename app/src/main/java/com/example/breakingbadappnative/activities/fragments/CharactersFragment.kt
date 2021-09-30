package com.example.breakingbadapp.activities.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.breakingbadapp.activities.adapters.CharacterListAdapter
import com.example.breakingbadapp.activities.models.Character
import com.example.breakingbadapp.activities.viewModel.CharacterViewModel
import com.example.breakingbadapp.databinding.FragmentCharactersBinding
import java.lang.ClassCastException


class CharactersFragment : Fragment() {

   public interface CharacterSelectListener{
        fun onCharacterSelected(character: Character)
    }
    private lateinit var characterSelectListener: CharacterSelectListener
    override fun onAttach(context: Context) {
        super.onAttach(context)

        characterSelectListener = try{
            context as CharacterSelectListener
        }catch (error: ClassCastException){
            throw  ClassCastException("$context must implement CharacterSelectListener")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val characterViewModel = ViewModelProvider(this).get(CharacterViewModel::class.java)
        val binding = FragmentCharactersBinding.inflate(inflater, container, false)

        characterViewModel.characters.observe(viewLifecycleOwner, Observer<MutableList<Character>>{
            characters ->
            val adapter = CharacterListAdapter(characters)
           adapter.onClickItem = {
                characterSelectListener.onCharacterSelected(it)
            }

            binding.recyclerCharactersList.layoutManager = LinearLayoutManager(requireActivity())
            binding.recyclerCharactersList.adapter = adapter
        })

        return binding.root
    }

}