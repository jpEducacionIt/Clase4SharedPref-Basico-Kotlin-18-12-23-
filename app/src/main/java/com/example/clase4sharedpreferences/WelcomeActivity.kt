package com.example.clase4sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class WelcomeActivity : AppCompatActivity() {
    private lateinit var textViewName : TextView
    private lateinit var imageView: ImageView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        textViewName = findViewById(R.id.textViewNameWelcome)
        imageView = findViewById(R.id.imageView)
        button = findViewById(R.id.buttonBorrar)

        val preferences = getSharedPreferences("appdata", MODE_PRIVATE)
        val namePref = preferences.getString("name", "")
        textViewName.text = namePref

        Glide.with(this)
            .load("https://i.ytimg.com/vi/zvgkGewzUq4/maxresdefault.jpg")
            .placeholder(R.drawable.pepe)
            .into(imageView)

        button.setOnClickListener {
            preferences.edit().clear().apply()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}