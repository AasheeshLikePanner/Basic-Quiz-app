package com.example.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import org.w3c.dom.Text

class Result : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        var subHead: TextView = findViewById(R.id.main)
        subHead.text = "You gave ${intent.getStringExtra("correct")} correct answers out of 3"
        Log.i("This is String IN Log REsult File", intent.getStringExtra("correct").toString())
    }
}