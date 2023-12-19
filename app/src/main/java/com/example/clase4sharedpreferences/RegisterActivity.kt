package com.example.clase4sharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {
    private lateinit var edtName: EditText
    private lateinit var edtPassword: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtName = findViewById(R.id.editTextNameReg)
        edtPassword = findViewById(R.id.editTextPasswordReg)
        button = findViewById(R.id.buttonReg)

        button.setOnClickListener {
        val name = edtName.text.toString()
        val password = edtPassword.text.toString()
            if (checkIsValid(name) && checkIsValid(password)) {
                savePreferences(name, password)
                navigateToLogin()
            } else {
                Toast.makeText(this, "debe ingresar ambos campos", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun navigateToLogin() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun savePreferences(name: String, password: String) {
        val preferences = getSharedPreferences("appdata", MODE_PRIVATE)
        val editor = preferences.edit().putString("name", name).putString("pass", password)
        editor.apply()
    }

    private fun checkIsValid(string: String) = string.isNotEmpty()
}