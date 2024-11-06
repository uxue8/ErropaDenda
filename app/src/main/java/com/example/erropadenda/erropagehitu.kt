package com.example.erropadenda

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class erropagehitu : AppCompatActivity() {

      lateinit var  erroizena: EditText
      lateinit var spmota: Spinner
      lateinit var taS: CheckBox
      lateinit var taM: CheckBox
      lateinit var taL: CheckBox
      lateinit var taXl: CheckBox
      lateinit var kolorea: EditText
      lateinit var prezioa: EditText
      lateinit var chBai:CheckBox
      lateinit var chEz: CheckBox
      lateinit var btnGehitu: Button
      val  ListaMota= arrayOf("Kamiseta","Praka","Jaka","Abrigoa")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContentView(R.layout.activity_erropagehitu)
        //ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
        //    val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
         //   v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
           // insets
       // }

        erroizena=findViewById(R.id.ediIzena)
        spmota=findViewById(R.id.spErMota)
        kolorea=findViewById(R.id.ediKolorea)
        prezioa=findViewById(R.id.ediPrezioa)
        taS=findViewById(R.id.chS)
        taM=findViewById(R.id.chM)
        taL=findViewById(R.id.chL)
        taXl=findViewById(R.id.chXL)
        chBai=findViewById(R.id.chBai)
        chEz=findViewById(R.id.chEz)
        btnGehitu=findViewById(R.id.btnErGehi)
        val adapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,ListaMota)
        spmota.adapter=adapter



    }


    fun gordeProduktua(){
        val admin = AdminSQLiteOpenHelper(this,"administracion",null,1)
        val bd=admin.writableDatabase

        val nom=erroizena.text.toString()
        val mota=findViewById<Spinner>(R.id.spErMota).selectedItem.toString()
        val kolorea=kolorea.text.toString()
        val pre=prezioa.text.toString().toInt()




    }
    fun toastAgertu(mezua : String){
        val t = Toast.makeText(this,mezua, Toast.LENGTH_SHORT)
        t.show()

    }


}