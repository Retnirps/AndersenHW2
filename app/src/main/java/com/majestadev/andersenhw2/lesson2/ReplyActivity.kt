package com.majestadev.andersenhw2.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.majestadev.andersenhw2.R

class ReplyActivity : AppCompatActivity() {
    companion object { val EXTRA_REPLY = "extra.REPLY" }
    private val LOG_TAG: String = ReplyActivity::class.java.simpleName


    private var replyEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reply)

        val message = intent.getStringExtra(SendActivity.EXTRA_MESSAGE)

        replyEditText = findViewById(R.id.replyEditText)
        val messageTextView = findViewById<TextView>(R.id.replyTextView)
        messageTextView.text = message
        Log.d(LOG_TAG, "-------")
        Log.d(LOG_TAG, "onCreate")
    }

    override fun onStart() {
        super.onStart()
        Log.d(LOG_TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d(LOG_TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d(LOG_TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d(LOG_TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(LOG_TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d(LOG_TAG, "onRestart")
    }

    fun replyToSendActivity(view: View) {
        val replyIntent = Intent(this, SendActivity::class.java)
            .putExtra(EXTRA_REPLY, replyEditText?.text.toString())
        setResult(RESULT_OK, replyIntent)
        Log.d(LOG_TAG, "End SecondActivity")
        finish()
    }
}