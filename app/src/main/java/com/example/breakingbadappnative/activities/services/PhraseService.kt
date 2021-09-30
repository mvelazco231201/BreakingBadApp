package com.example.breakingbadapp.activities.services

import com.example.breakingbadapp.activities.api.api
import com.example.breakingbadapp.activities.api.responsePhrase
import retrofit2.http.GET

interface PhraseService {

    @GET("quote/random")

    suspend fun getPhrase(): responsePhrase
}
var phraseService: PhraseService = api.create<PhraseService>(PhraseService::class.java)