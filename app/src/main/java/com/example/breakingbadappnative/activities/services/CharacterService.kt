package com.example.breakingbadapp.activities.services

import com.example.breakingbadapp.activities.api.Response
import com.example.breakingbadapp.activities.api.api
import retrofit2.http.GET

interface CharacterService {

    @GET("characters")

    suspend fun getCharacter(): Response
}
var characterService: CharacterService = api.create<CharacterService>(CharacterService::class.java)