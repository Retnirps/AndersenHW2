package com.majestadev.andersenhw2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import java.lang.Exception

class HappyBirthdayActivity : AppCompatActivity() {
    private val LOG_E_TAG = HappyBirthdayActivity::class.java.simpleName

    private var happyBirthdayTextView: TextView? = null
    private var editTextTextPersonName: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_happy_birthday)

        happyBirthdayTextView = findViewById<TextView>(R.id.happyBirthdayTextView)
        editTextTextPersonName = findViewById<EditText>(R.id.editTextTextPersonName)
    }

    @SuppressLint("SetTextI18n")
    fun congratulateThePerson(view: View) {
//        Log.e example
        try {
            val x = 10 / 0
        } catch (e: Exception) {
            Log.e(LOG_E_TAG, "Exception")
        }
//

        happyBirthdayTextView?.text = "Happy Birthday to ${editTextTextPersonName?.text}"
    }
}