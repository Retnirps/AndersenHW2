package com.majestadev.andersenhw2.lesson2

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.majestadev.andersenhw2.R
import android.provider.MediaStore





class ImplicitIntentsActivity : AppCompatActivity() {
    private var mWebsiteEditText: EditText? = null
    private var mLocationEditText: EditText? = null
    private var mShareTextEditText: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_implicit_intents)
        mWebsiteEditText = findViewById(R.id.website_edittext)
        mLocationEditText = findViewById(R.id.location_edittext)
        mShareTextEditText = findViewById(R.id.share_edittext)
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun openWebsite(view: View?) {
        // Get the URL text.
        val url = mWebsiteEditText!!.text.toString()

        // Parse the URI and create the intent.
        val webpage: Uri = Uri.parse(url)
        val intent = Intent(Intent.ACTION_VIEW, webpage)

        // Find an activity to hand the intent and start that activity.
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun openLocation(view: View?) {
        // Get the string indicating a location. Input is not validated; it is
        // passed to the location handler intact.
        val loc = mLocationEditText!!.text.toString()

        // Parse the location and create the intent.
        val addressUri = Uri.parse("geo:0,0?q=$loc")
        val intent = Intent(Intent.ACTION_VIEW, addressUri)

        // Find an activity to handle the intent, and start that activity.
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }
    }

    fun shareText(view: View?) {
        val txt = mShareTextEditText!!.text.toString()
        val mimeType = "text/plain"
        ShareCompat.IntentBuilder
            .from(this)
            .setType(mimeType)
            .setChooserTitle(getString(R.string.share_text_with))
            .setText(txt)
            .startChooser()
    }

    @SuppressLint("QueryPermissionsNeeded")
    fun takePicture(view: View?) {
        val REQUEST_IMAGE_CAPTURE = 1

        val takePictureIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE)
        } else {
            Log.d("ImplicitIntents", "Can't handle this intent!")
        }

    }
}