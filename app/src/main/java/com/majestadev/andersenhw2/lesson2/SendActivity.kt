package com.majestadev.andersenhw2.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import com.majestadev.andersenhw2.R

class SendActivity : AppCompatActivity() {
    private val LOG_TAG = SendActivity::class.java.simpleName
    val TEXT_REQUEST = 1
    companion object { val EXTRA_MESSAGE = "extra.MESSAGE" }

    private var replyReceiverTextView: TextView? = null
    private var replyTextView: TextView? = null
    private var messageEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send)
        messageEditText = findViewById(R.id.messageEditText)
        replyReceiverTextView = findViewById(R.id.replyReceiverTextView)
        replyTextView = findViewById(R.id.replyTextView)

        // Restore the state.
        if (savedInstanceState != null) {
            val isVisible = savedInstanceState.getBoolean("reply_visible")
            if (isVisible) {
                replyReceiverTextView?.visibility = View.VISIBLE
                replyTextView?.text = savedInstanceState.getString("reply_text")
                replyTextView?.visibility = View.VISIBLE
            }
        }

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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        if (replyReceiverTextView?.visibility == View.VISIBLE) {
            outState.putBoolean("reply_visible", true)
            outState.putString("reply_text", replyTextView?.text.toString())
        }
    }

    fun sendMessageToReplyActivity(view: View) {
        Log.d(LOG_TAG, "Button clicked!")
        val intent = Intent(this, ReplyActivity::class.java)
            .putExtra(EXTRA_MESSAGE, messageEditText?.text.toString())
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(ReplyActivity.EXTRA_REPLY)
                replyReceiverTextView?.visibility = View.VISIBLE
                replyTextView?.text = reply
                replyTextView?.visibility = View.VISIBLE
            }
        }
    }
}