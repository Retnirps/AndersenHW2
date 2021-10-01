package com.majestadev.andersenhw2.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.majestadev.andersenhw2.R

class TextViewerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_text_viewer)

        val scrollableTextView: TextView = findViewById(R.id.scrollableTextView)

        val text = intent.getStringExtra(SelectTextActivity.EXTRA_TEXT)

        scrollableTextView.text = text
    }
}