package com.example.erropadenda

import android.content.ContentValues
import android.content.Intent
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
    lateinit var btnEzabatu: Button
    val  ListaMota= arrayOf("Kamiseta","Praka","Jaka","Abrigoa")
    private var  kodeaID : Int? =null
    private var originalIzena: String? = null
    private var originalMota: String? = null
    private var originalTalla: String? = null
    private var originalKolorea: String? = null
    private var originalPrezioa: String? = null
    private var originalEskuragarritasuna: String? = null
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
        kodeaID = intent.getIntExtra("id",-1)
        originalIzena= intent.getStringExtra("izena")
        originalMota= intent.getStringExtra("mota")
        originalTalla= intent.getStringExtra("talla")
        originalKolorea = intent.getStringExtra("kolorea")
        originalPrezioa = intent.getStringExtra("prezioa")
        originalEskuragarritasuna= intent.getStringExtra("eskuragarritasuna")


        //poner los datos en la pantalla


        erroizenaEd.setText(originalIzena)
        //zenbakiak array-aren posizioak dira
        when(originalMota){
           "Kamiseta"-> spmotaEd.setSelection(0)
            "Praka"->spmotaEd.setSelection(1)
            "Jaka"->spmotaEd.setSelection(2)
            "Abrigoa"->spmotaEd.setSelection(3)
            else-> noEncontrado=true
       }
        when(originalTalla){
            "S"->taSEd.setChecked(true)
            "M"->taMEd.setChecked(true)
            "L"->taLEd.setChecked(true)
            "XL"->taXlEd.setChecked(true)
            else-> noEncontrado=true
        }
        koloreaEd.setText(originalKolorea)
        prezioaEd.setText(originalPrezioa)
        when(originalEskuragarritasuna){
            "bai"->chBaiEd.setChecked(true)
            "ez"->chEzEd.setChecked(true)
            else-> noEncontrado=true
        }

        // Zerrendara bueltatu
        btnBuelta.setOnClickListener{
            val i= Intent(this,erropaZerrenda::class.java)
            startActivity(i)
        }

        //Editatu

        btnEditatu.setOnClickListener{

        }

    }

    fun erropaEditatu(){
        var noCambia=false


        val ize= erroizenaEd.text.toString()
        val mo=findViewById<Spinner>(R.id.spErMotaEd).selectedItem.toString()
        val esku= when{

            chBaiEd.isChecked-> "bai"
            chEzEd.isChecked->"ez"
            else -> ""
        }
        val ta = when {
            taSEd.isChecked -> "S"
            taMEd.isChecked -> "M"
            taLEd.isChecked -> "L"
            taXlEd.isChecked -> "XL"
            else -> ""
        }
        val kol = koloreaEd.text.toString()
        val prezi = prezioaEd.text.toString()
        if(ize==originalIzena &&  mo==originalMota && esku==originalEskuragarritasuna && ta==originalTalla && kol==originalKolorea && prezi==originalPrezioa){

            noCambia=true
        }
        if(noCambia){
            toastAgertu("ez duzu ezer aldatu")
        }else{

           if (ize!=originalIzena){
               Aldatu("izena",ize)
           }
            if(mo!=originalMota){
                Aldatu("mota",mo)
            }
            if (esku!=originalEskuragarritasuna){
                Aldatu("eskuragarritasuna",esku)
            }
            if(kol!=originalKolorea){
                Aldatu("kolorea",kol)
            }
            if(prezi!=originalPrezioa){
                Aldatu("prezioa",prezi)
            }



        }



    }
    fun toastAgertu(mezua : String){
        val t = Toast.makeText(this,mezua, Toast.LENGTH_SHORT)
        t.show()

    }
    fun Aldatu(key: String,erropa :String){
        val admin = AdminSQLiteOpenHelper(this,"administracion",null,1)
        val bd=admin.writableDatabase
        val registro= ContentValues()
        registro.put("kodea", kodeaID )
        registro.put(key,erropa)
        val kopurua= bd.update("productos",registro,"kodea=$kodeaID",null)
        bd.close()
        if(kopurua==1){
            toastAgertu("$key aldatu da")
        }else{
            toastAgertu("ez da ezer aldatu")
        }
    }
}