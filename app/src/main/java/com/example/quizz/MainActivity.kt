package com.example.quizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val but:AppCompatButton = findViewById(R.id.start_button)
        val textBox:AppCompatEditText = findViewById(R.id.TextBox)

        but.setOnClickListener {
            if(textBox.text?.isEmpty() == true){
                Toast.makeText(this,"Please enter the text",Toast.LENGTH_SHORT).show()
            }
            else{
                val intent = Intent(this, questionPage::class.java)
                startActivity(intent)
            }
        }
    }
}