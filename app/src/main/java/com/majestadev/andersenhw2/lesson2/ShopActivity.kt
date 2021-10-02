package com.majestadev.andersenhw2.lesson2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import com.majestadev.andersenhw2.R

class ShopActivity : AppCompatActivity() {
    companion object { val EXTRA_PRODUCT = "extra.REPLY" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)
    }

    fun selectProduct(view: View?) {
        if (view != null) {
            val productName = (view as Button).text.toString()
            replyToSendActivity(productName)
        }
    }

    private fun replyToSendActivity(productName: String) {
        val replyIntent = Intent(this, ShoppingListActivity::class.java)
            .putExtra(EXTRA_PRODUCT, productName)
        setResult(RESULT_OK, replyIntent)
        finish()
    }
}