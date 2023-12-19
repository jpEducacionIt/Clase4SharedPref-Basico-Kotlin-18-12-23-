package com.example.clase4sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private lateinit var button: Button
    private lateinit var edtName: EditText
    private lateinit var edtPass: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        edtName = findViewById(R.id.editTextName)
        edtPass = findViewById(R.id.editTextPassword)

        val preferences = getSharedPreferences("appdata", MODE_PRIVATE)
        val namePref = preferences.getString("name", "")
        val passwordPref = preferences.getString("pass", "")

        if (namePref == "" && passwordPref == "") {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val name = edtName.text.toString()
            val pass = edtPass.text.toString()

            if (checkIsValid(name) && checkIsValid(pass)) {
                if (name == namePref && pass == passwordPref) {
                    val intent = Intent(this, WelcomeActivity::class.java)
                    startActivity(intent)
                } else {
                    Toast.makeText(this, "USUARIO O CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
    private fun checkIsValid(string: String) = string.isNotEmpty()
}