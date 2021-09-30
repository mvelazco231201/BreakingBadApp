package com.example.breakingbadapp.activities.viewModel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.breakingbadapp.activities.models.Character
import com.example.breakingbadapp.activities.services.characterService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import androidx.lifecycle.viewModelScope

class CharacterViewModel: ViewModel() {
    private var _characters = MutableLiveData<MutableList<Character>>()
    val characters: LiveData<MutableList<Character>>
        get()=_characters

    init {

        viewModelScope.launch {
            _characters.value = fetch()
        }
    }

    private suspend fun fetch(): MutableList<Character>{
        return withContext(Dispatchers.IO){
            val character: MutableList<Character> = characterService.getCharacter()
            character
        }
    }
}