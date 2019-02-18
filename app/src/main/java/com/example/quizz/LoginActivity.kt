package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun sendNickname(view: View) {
        val nickname = loginName.text.toString()
        val intent = Intent(this, MainActivity::class.java).apply {
            putExtra("nickname", nickname)
        }
        startActivity(intent)
    }

}
