package com.example.myapplication2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        val message = intent.getStringExtra("EXTRA_MESSAGE")

        val textView = findViewById<TextView>(R.id.textView).apply {
            text = message
        }

    }
}