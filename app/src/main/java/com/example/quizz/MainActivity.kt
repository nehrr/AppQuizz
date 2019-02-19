package com.example.quizz

import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.navigation.NavigationView
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    var ind = 0
    var points: Int = 0
    var nickname: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        this.nickname = User.nickname
        question.text = Questions.map[this.ind]?.question
        answer1.text = Questions.map[this.ind]?.a1
        answer2.text = Questions.map[this.ind]?.a2
        answer3.text = Questions.map[this.ind]?.a3
        scorePoints.text = this.points.toString()

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_profile -> {
                val intent = Intent(this, ProfileActivity::class.java).apply {
                    val profileName = nickname
                    putExtra("nickname", nickname)
            }
                startActivity(intent)
            }
            R.id.nav_admin -> {
                val intent = Intent(this, MainAdminActivity::class.java).apply {
                }
                startActivity(intent)

            }

            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }

    fun onPushVal(view: View) {
        val name = view.context.resources.getResourceEntryName(view.id)

        if (name == Questions.map[this.ind]?.solution) {
            this.points++
            Toast.makeText(applicationContext, "Good job, you now have ${this.points} points", Toast.LENGTH_SHORT).show()
        } else {
            //if (this.points > 0) this.points-- else this.points = 0
            Toast.makeText(applicationContext, "Sorry, you got the wrong answer", Toast.LENGTH_SHORT).show()
        }


        if (this.ind < Questions.map.size -1) {
            this.ind++
        } else {
            this.ind = 0
            Toast.makeText(applicationContext, "Congrats, you finished the game with ${this.points} points", Toast.LENGTH_SHORT).show()
            this.points = 0
        }

        question.text = Questions.map[this.ind]?.question
        answer1.text = Questions.map[this.ind]?.a1
        answer2.text = Questions.map[this.ind]?.a2
        answer3.text = Questions.map[this.ind]?.a3
        scorePoints.text = this.points.toString()
    }
}
