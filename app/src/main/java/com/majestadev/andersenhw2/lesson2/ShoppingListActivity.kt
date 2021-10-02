package com.majestadev.andersenhw2.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.TextView
import com.majestadev.andersenhw2.R
import org.w3c.dom.Text

class ShoppingListActivity : AppCompatActivity() {
    val TEXT_REQUEST = 1
    private var textInTextViews = Array(10) { "Empty" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_list)

        if (savedInstanceState != null) {
            textInTextViews = savedInstanceState.getStringArray("text_in_text_views") as Array<String>
            var textView: TextView?
            for (i in 0..9) {
                if (textInTextViews[i] != "Empty") {
                    textView = when (i) {
                        0 -> findViewById(R.id.textView)
                        1 -> findViewById(R.id.textView2)
                        2 -> findViewById(R.id.textView3)
                        3 -> findViewById(R.id.textView4)
                        4 -> findViewById(R.id.textView5)
                        5 -> findViewById(R.id.textView6)
                        6 -> findViewById(R.id.textView7)
                        7 -> findViewById(R.id.textView8)
                        8 -> findViewById(R.id.textView9)
                        9 -> findViewById(R.id.textView10)
                        else -> null
                    }
                    textView?.text = textInTextViews[i]
                }
            }
        }
    }

    fun openShop(view: View?) {
        val intent = Intent(this, ShopActivity::class.java)
        startActivityForResult(intent, TEXT_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply = data?.getStringExtra(ShopActivity.EXTRA_PRODUCT)
                val textView: TextView?

                for (i in 0..9) {
                    if (textInTextViews[i] == "Empty") {
                        textView = when (i) {
                            0 -> findViewById(R.id.textView)
                            1 -> findViewById(R.id.textView2)
                            2 -> findViewById(R.id.textView3)
                            3 -> findViewById(R.id.textView4)
                            4 -> findViewById(R.id.textView5)
                            5 -> findViewById(R.id.textView6)
                            6 -> findViewById(R.id.textView7)
                            7 -> findViewById(R.id.textView8)
                            8 -> findViewById(R.id.textView9)
                            9 -> findViewById(R.id.textView10)
                            else -> null
                        }

                        if (reply != null) {
                            textInTextViews[i] = reply
                        }
                        textView?.text = reply

                        break
                    }
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putStringArray("text_in_text_views", textInTextViews)
    }
}