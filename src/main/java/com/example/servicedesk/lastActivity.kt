package com.example.servicedesk

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class lastActivity : AppCompatActivity() {

    lateinit var userName : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last)

         userName = findViewById(R.id.textView6)
                var sharedPreferences =getSharedPreferences("userNameS", Context.MODE_PRIVATE)
        var userNameTwo = sharedPreferences.getString("user_name","None")

        val thxMsg = "Thank You $userNameTwo"
        userName.setText(thxMsg)
    }
}