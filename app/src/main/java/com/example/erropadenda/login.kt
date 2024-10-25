package com.example.erropadenda

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.LogPrinter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
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

        btnSaHa.setOnClickListener{
            login()
        }
    }

    fun login(){

        val ema=emailTxt.text.toString()
        val contra=passTxt.text.toString()
        val admin = AdminSQLiteOpenHelper(this,"administracion",null,1)
        val bd=admin.writableDatabase

        val lerroa=bd.rawQuery("select * from usuarios where email=$ema and pasahitza=$contra",null)
        if(lerroa.moveToFirst()){
            toastAgertu("Ongi etorri")
            val i= Intent(this,MainActivity::class.java)
            startActivity(i)

        }else{
            toastAgertu("erabiltzaile hori ez dago gure datubasean")
        }
    }
    fun toastAgertu(mezua : String){
        val t = Toast.makeText(this,mezua, Toast.LENGTH_SHORT)
        t.show()

    }

}