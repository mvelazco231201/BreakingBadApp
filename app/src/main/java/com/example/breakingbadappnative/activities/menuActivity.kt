package com.example.breakingbadappnative.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.breakingbadapp.R
import com.example.breakingbadapp.activities.adapters.ViewPagerAdapter
import com.example.breakingbadapp.activities.detail.DetailActivity
import com.example.breakingbadapp.activities.fragments.CharactersFragment
import com.example.breakingbadapp.activities.fragments.PhraseFragment
import com.example.breakingbadapp.activities.fragments.SettingsFragment
import com.example.breakingbadapp.activities.models.Character
import com.example.breakingbadapp.databinding.ActivityMenuBinding

class menuActivity : AppCompatActivity(), CharactersFragment.CharacterSelectListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        setUpTabs()
    }

    private fun setUpTabs() {
        val binding = DataBindingUtil.setContentView<ActivityMenuBinding>(
            this,
            R.layout.activity_menu
        )
        val adapter = ViewPagerAdapter(supportFragmentManager)

        val char = getString(R.string.Characters)
        val phrase = getString(R.string.Phrase)
        val setti = getString(R.string.Settings)

        adapter.addFragment(CharactersFragment(), char)
        adapter.addFragment(PhraseFragment(), phrase)
        adapter.addFragment(SettingsFragment(), setti)
        binding.viewPager.adapter = adapter
        binding.tabs.setupWithViewPager(binding.viewPager)

        binding.tabs.getTabAt(0)!!.setIcon(R.drawable.ic_characters)
        binding.tabs.getTabAt(1)!!.setIcon(R.drawable.ic_phrase)
        binding.tabs.getTabAt(2)!!.setIcon(R.drawable.ic_setting)
    }

    override fun onCharacterSelected(character: Character) {
        val intent = Intent(this, DetailActivity::class.java).apply {
            putExtra(DetailActivity.CHARACTER_KEY, character)
        }
        startActivity(intent)
    }
}