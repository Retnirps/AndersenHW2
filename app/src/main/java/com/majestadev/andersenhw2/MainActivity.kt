package com.majestadev.andersenhw2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.majestadev.andersenhw2.lesson1.HelloConstraint
import com.majestadev.andersenhw2.lesson1.HelloToastActivity
import com.majestadev.andersenhw2.lesson1.HelloToastChallengeActivity
import com.majestadev.andersenhw2.lesson1.ScrollingTextActivity
import com.majestadev.andersenhw2.lesson2.HelloToastV2Activity
import com.majestadev.andersenhw2.lesson2.SelectTextActivity
import com.majestadev.andersenhw2.lesson2.SendActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun startHelloWorldActivity(view: View) {
        startActivity(Intent(this, HelloWorldActivity::class.java))
    }

    fun startHappyBirthdayActivity(view: View) {
        startActivity(Intent(this, HappyBirthdayActivity::class.java))
    }

    fun startSendActivity(view: View) {
        startActivity(Intent(this, SendActivity::class.java))
    }

    fun startSelectTextActivity(view: View) {
        startActivity(Intent(this, SelectTextActivity::class.java))
    }

    fun startHelloToastActivity(view: View) {
        startActivity(Intent(this, HelloToastActivity::class.java))
    }

    fun startHelloToastChallengeActivity(view: View) {
        startActivity(Intent(this, HelloToastChallengeActivity::class.java))
    }

    fun startHelloConstraintActivity(view: View) {
        startActivity(Intent(this, HelloConstraint::class.java))
    }

    fun startScrollingTextActivity(view: View) {
        startActivity(Intent(this, ScrollingTextActivity::class.java))
    }

    fun startHelloToastV2Activity(view: View) {
        startActivity(Intent(this, HelloToastV2Activity::class.java))
    }
}