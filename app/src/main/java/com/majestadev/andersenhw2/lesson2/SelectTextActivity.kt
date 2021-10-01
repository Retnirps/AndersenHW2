package com.majestadev.andersenhw2.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.majestadev.andersenhw2.R

class SelectTextActivity : AppCompatActivity() {
    companion object { val EXTRA_TEXT = "extra.TEXT" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_text)

        val textOneButton: Button = findViewById(R.id.textOneButton)
        val textTwoButton: Button = findViewById(R.id.textTwoButton)
        val textThreeButton: Button = findViewById(R.id.TextThreeButton)

        textOneButton.setOnClickListener {
            startTextViewerActivityWithText(1)
        }

        textTwoButton.setOnClickListener {
            startTextViewerActivityWithText(2)
        }

        textThreeButton.setOnClickListener {
            startTextViewerActivityWithText(3)
        }
    }

    fun startTextViewerActivityWithText(textNumber: Int) {
        val text = when (textNumber) {
            1 -> getString(R.string.random_text_1)
            2 -> getString(R.string.random_text_2)
            3 -> getString(R.string.random_text_3)
            else -> ""
        }
        val intent = Intent(this, TextViewerActivity::class.java)
            .putExtra(EXTRA_TEXT, text)
        startActivity(intent)
    }
}