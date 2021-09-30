package com.example.breakingbadapp.activities.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.breakingbadapp.activities.models.Phrase
import com.example.breakingbadapp.activities.services.phraseService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class PhraseViewModel: ViewModel() {
    private var _phrases = MutableLiveData<MutableList<Phrase>>()
    val phrases: LiveData<MutableList<Phrase>>
            get()=_phrases

    init {

        viewModelScope.launch {
            _phrases.value = fetch()
        }
    }

    private suspend fun fetch(): MutableList<Phrase> {
        return withContext(Dispatchers.IO){
            val phrase: MutableList<Phrase> = phraseService.getPhrase()
            phrase
        }
    }

    fun fetchInfo(){
        viewModelScope.launch {
            _phrases.value = fetch()
        }
    }
}