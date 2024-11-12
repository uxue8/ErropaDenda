package com.example.erropadenda

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductDetailActivity : AppCompatActivity() {
    lateinit var  erroizenaEd: EditText
    lateinit var spmotaEd: Spinner
    lateinit var taSEd: CheckBox
    lateinit var taMEd: CheckBox
    lateinit var taLEd: CheckBox
    lateinit var taXlEd: CheckBox
    lateinit var koloreaEd: EditText
    lateinit var prezioaEd: EditText
    lateinit var chBaiEd: CheckBox
    lateinit var chEzEd: CheckBox
    lateinit var btnEditatu: Button
    lateinit var btnBuelta: Button
    val  ListaMota= arrayOf("Kamiseta","Praka","Jaka","Abrigoa")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_product_detail)

        erroizenaEd=findViewById(R.id.ediIzenaEd)
        spmotaEd=findViewById(R.id.spErMotaEd)
        koloreaEd=findViewById(R.id.ediKoloreaEd)
        prezioaEd=findViewById(R.id.ediPrezioaEd)
        taSEd=findViewById(R.id.chSEd)
        taMEd=findViewById(R.id.chMEd)
        taLEd=findViewById(R.id.chLEd)
        taXlEd=findViewById(R.id.chXLEd)
        chBaiEd=findViewById(R.id.chBaiEd)
        chEzEd=findViewById(R.id.chEzEd)
        btnEditatu=findViewById(R.id.btnErEdi)
        btnBuelta=findViewById(R.id.btnBueltaEd)
        val adapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,ListaMota)
        spmotaEd.adapter=adapter
        var noEncontrado=false
        //los datos cogidos de la pantalla zerrenda
        val kode = intent.getIntExtra("id",-1)
        val ize= intent.getStringExtra("izena")
        val spMo= intent.getStringExtra("mota")
        val ta= intent.getStringExtra("talla")
        val ko = intent.getStringExtra("kolorea")
        val pre = intent.getStringExtra("prezioa")
        val esku= intent.getStringExtra("eskuragarritasuna")



        //poner los datos en la pantalla


        erroizenaEd.setText(ize)
        //zenbakiak array-aren posizioak dira
        when(spMo){
           "Kamiseta"-> spmotaEd.setSelection(0)
            "Praka"->spmotaEd.setSelection(1)
            "Jaka"->spmotaEd.setSelection(2)
            "Abrigoa"->spmotaEd.setSelection(3)
            else-> noEncontrado=true
       }
        when(ta){
            "S"->taSEd.setChecked(true)
            "M"->taMEd.setChecked(true)
            "L"->taLEd.setChecked(true)
            "XL"->taXlEd.setChecked(true)
            else-> noEncontrado=true
        }
        koloreaEd.setText(ko)
        prezioaEd.setText(pre)
        when(esku){
            "bai"->chBaiEd.setChecked(true)
            "ez"->chEzEd.setChecked(true)
            else-> noEncontrado=true
        }

        // Zerrendara bueltatu
        btnBuelta.setOnClickListener{
            val i= Intent(this,erropaZerrenda::class.java)
            startActivity(i)
        }



    }
}