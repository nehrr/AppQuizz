package com.example.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_profile.*

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profileName.text = User.nickname
    }

    fun updateUsername(view: View) {
        val newUser = editUsername.text.toString()

        if (newUser != User.nickname && newUser != "") {
            Toast.makeText(applicationContext, "You changed your username from ${User.nickname} to ${newUser}", Toast.LENGTH_SHORT).show()

            User.nickname = newUser
            profileName.text = User.nickname
        }
    }
}