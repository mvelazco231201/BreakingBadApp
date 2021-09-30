package com.example.breakingbadapp.activities.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.bumptech.glide.Glide
import com.example.breakingbadapp.R
import com.example.breakingbadapp.activities.fragments.CharactersFragment
import com.example.breakingbadapp.activities.models.Character
import com.example.breakingbadapp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity(){

    companion object{
        const val CHARACTER_KEY = "character_item"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding =
            DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        val bundle: Bundle? = intent.extras

        if (bundle != null) {
            val character = bundle.getParcelable<Character>(CHARACTER_KEY)
            Glide
                .with(binding.root)
                .load(character?.img)
                .circleCrop()
                .placeholder(R.drawable.ic_carga)
                .into(binding.profile)
            binding.name.text = character?.name
            binding.nickname.text = character?.nickname
            binding.birthday.text = character?.birthday
            binding.portrayed.text = character?.portrayed
            binding.occupation.text = character?.occupation?.joinToString()
            binding.status.text = character?.status
            when (character?.status) {
                "Alive" -> {
                    Glide
                        .with(binding.root)
                        .load(R.drawable.ic_alive)
                        .circleCrop()
                        .placeholder(R.drawable.ic_carga)
                        .into(binding.imageView2)
                }
                "Deceased" -> {
                    Glide
                        .with(binding.root)
                        .load(R.drawable.ic_deceased)
                        .circleCrop()
                        .placeholder(R.drawable.ic_carga)
                        .into(binding.imageView2)
                }

                "Presumed dead" -> {

                    Glide
                        .with(binding.root)
                        .load(R.drawable.ic_presumeddead)
                        .circleCrop()
                        .placeholder(R.drawable.ic_carga)
                        .into(binding.imageView2)
                }

                "Unknown" -> {
                    Glide
                        .with(binding.root)
                        .load(R.drawable.ic_unknown)
                        .circleCrop()
                        .placeholder(R.drawable.ic_carga)
                        .into(binding.imageView2)
                }

            }
        }
    }
}