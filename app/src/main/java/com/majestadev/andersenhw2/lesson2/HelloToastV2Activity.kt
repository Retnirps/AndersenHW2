package com.majestadev.andersenhw2.lesson2

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.majestadev.andersenhw2.R


class HelloToastV2Activity : AppCompatActivity() {
    companion object { val EXTRA_COUNTER = "extra.COUNTER" }
    private var mCount = 0
    private var mShowCount: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_toast_v2)
        mShowCount = findViewById<View>(R.id.show_count_v2) as TextView
    }

    fun sayHello(view: View?) {
        val intent = Intent(this, HelloCountActivity::class.java)
            .putExtra(EXTRA_COUNTER, mShowCount?.text)
        startActivity(intent)
    }

    fun countUp(view: View?) {
        mCount++
        if (mShowCount != null) mShowCount!!.text = mCount.toString()
    }
}