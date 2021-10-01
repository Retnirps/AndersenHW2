package com.majestadev.andersenhw2

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class HelloWorldActivity : AppCompatActivity() {
    private val LOG_TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hello_world)
        Log.d(LOG_TAG, "Hello World")
    }
}