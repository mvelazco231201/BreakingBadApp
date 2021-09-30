package com.example.breakingbadapp.activities.main

import android.content.Intent
import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.breakingbadapp.R
import com.example.breakingbadapp.databinding.ActivityMainBinding
import com.example.breakingbadappnative.activities.menuActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bindingLogin = DataBindingUtil.setContentView<ActivityMainBinding>(this,
            R.layout.activity_main)

        var img = bindingLogin.loadingView
        img.setBackgroundResource(R.drawable.loading)

        var frameAnimationimg = img.getBackground() as AnimationDrawable
        frameAnimationimg.start();

        val alert = getString(R.string.alert)

        bindingLogin.button.setOnClickListener() {
            if (bindingLogin.EmailAddress.text.isEmpty() || !isEmailValid(bindingLogin.EmailAddress.text.toString()) || bindingLogin.Password.text.isEmpty()) {
                Toast.makeText(this, alert, Toast.LENGTH_LONG)
                    .show()
            }
            else{
                val intent = Intent(this, menuActivity::class.java)
                startActivity(intent)
            }
        }

    }

    private fun isEmailValid(email: String): Boolean {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

}