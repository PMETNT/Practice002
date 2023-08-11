package com.example.selfintroductionapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {

    lateinit var aRL: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signin)

        val input_id = findViewById<EditText>(R.id.input_id)
        val input_pw = findViewById<EditText>(R.id.input_pw)

        val loginButton = findViewById<TextView>(R.id.loginButton)
        val creatButton = findViewById<TextView>(R.id.creatButton)

        aRL = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                val id = it.data?.getStringExtra("id") ?: ""
                val pw = it.data?.getStringExtra("pw") ?: ""
                input_id.setText(id)
                input_pw.setText(pw)


            }
        }



        loginButton.setOnClickListener {
            if(input_id.text.toString().trim().isEmpty() || input_pw.text.toString().trim().isEmpty()){
                Toast.makeText(getApplicationContext(), getString(R.string.toast_check), Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("id", input_id.text.toString())
            Toast.makeText(getApplicationContext(), getString(R.string.toast_login), Toast.LENGTH_SHORT).show()
            startActivity(intent)
        }

        creatButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            aRL.launch(intent)
        }





    }
}