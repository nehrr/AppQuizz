package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun sendNickname(view: View) {
        val nickname = loginName.text.toString()

        if (nickname == "") {
            Toast.makeText(applicationContext,"Your nickname cannot be null",
                Toast.LENGTH_SHORT).show()

        } else {
            val intent = Intent(this, MainActivity::class.java).apply {
                User.nickname = nickname
            }
            startActivity(intent)
        }
    }

}
