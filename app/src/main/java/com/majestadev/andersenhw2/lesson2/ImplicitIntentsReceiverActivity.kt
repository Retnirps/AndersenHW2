package com.majestadev.andersenhw2.lesson2

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.majestadev.andersenhw2.R


class ImplicitIntentsReceiverActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents_receiver)

        val uri = intent.data
        if (uri != null) {
            val uriString = "URI: $uri"
            val textView = findViewById<TextView>(R.id.text_uri_message)
            textView.text = uriString
        }
    }
}