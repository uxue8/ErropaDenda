package com.example.erropadenda

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class login : AppCompatActivity() {
    lateinit var   emailTxt: EditText
    lateinit var   passTxt: EditText
    lateinit var  btnSaHa: Button
    lateinit var  btnErre: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        setContentView(R.layout.login)

        emailTxt=findViewById (R.id.txtEmail)
        passTxt=findViewById(R.id.txtPass)
        btnSaHa=findViewById(R.id.btnHasi)
        btnErre=findViewById(R.id.btnErregis)


        btnErre.setOnClickListener {

            val i= Intent(this,erregistro::class.java)
            startActivity(i)

        }
    }

}