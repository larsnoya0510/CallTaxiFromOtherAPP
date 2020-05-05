package com.example.calltaxifromotherapp

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        linkTextView.setMovementMethod(LinkMovementMethod.getInstance())
        appButton.setOnClickListener { view ->
            val uri = "yes-taxi://" // 目標
            val intent = Intent()
            intent.action = Intent.ACTION_VIEW
            intent.addCategory(Intent.CATEGORY_BROWSABLE)
            intent.addCategory(Intent.CATEGORY_DEFAULT)
            intent.data = Uri.parse(uri)
            try {
                startActivity(intent)
            }
            catch (e: ActivityNotFoundException) {
                Log.d("errorLog",e.toString())
            }

        }
    }
}
