package com.majestadev.andersenhw2.lesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.majestadev.andersenhw2.R

class CounterHomeworkActivity : AppCompatActivity() {
    private var counterTextView: TextView? = null
    private var editText: EditText? = null
    private var counter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter_homework)
        counterTextView = findViewById(R.id.counterTextView)
        counterTextView?.text = counter.toString()
        editText = findViewById(R.id.editText)

        if (savedInstanceState != null) {
            counter = savedInstanceState.getInt("counter")
            counterTextView?.text = counter.toString()
            editText?.setText(savedInstanceState.getString("edit_text"))
        }
    }

    fun countUp(view: View?) {
        counter++
        if (counterTextView != null) counterTextView?.text = counter.toString()
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("counter", counter)
        outState.putString("edit_text", editText?.text.toString())
    }
}