package com.example.selfintroductionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val creat_name = findViewById<EditText>(R.id.creat_name)
        val creat_id = findViewById<EditText>(R.id.creat_id)
        val creat_pw = findViewById<EditText>(R.id.creat_pw)

        val signUpButton = findViewById<TextView>(R.id.signUpButton)

        signUpButton.setOnClickListener {
            if(creat_id.text.toString().trim().isEmpty() || creat_pw.text.toString().trim().isEmpty()){
                Toast.makeText(getApplicationContext(), getString(R.string.toast_check1), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, SignInActivity::class.java).apply {
                putExtra("id", creat_id.text.toString())
                putExtra("pw", creat_pw.text.toString())

            }
            setResult(RESULT_OK, intent)
            Toast.makeText(getApplicationContext(), getString(R.string.toast_check2), Toast.LENGTH_SHORT).show()
            if(!isFinishing)finish()
        }

    }
}