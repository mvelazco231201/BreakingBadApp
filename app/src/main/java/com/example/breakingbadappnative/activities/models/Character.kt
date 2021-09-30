package com.example.breakingbadapp.activities.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class Character (
        val name: String,
        val birthday: String,
        val occupation: Array<String>,
        val img: String,
        val status: String,
        val nickname: String,
        val appearance: Array<String>,
        val portrayed: String,
        val category: String
        ) : Parcelable {
      }