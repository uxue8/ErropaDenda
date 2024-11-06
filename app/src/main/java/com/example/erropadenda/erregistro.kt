package com.example.erropadenda

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
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

class erregistro : AppCompatActivity() {

    lateinit var btnErre: Button
    lateinit var btnBuel: Button
    lateinit var izena: EditText
    lateinit var abizena: EditText
    lateinit var Pasa: EditText
    lateinit var ema: EditText
    lateinit var  spArrogus: Spinner
    lateinit var spEgoHi: Spinner
    lateinit var chAlAlgo:CheckBox
    lateinit var chAlPol: CheckBox
    val ListaArroGus= arrayOf("Kamiseta","Praka","Jaka","Abrigoa")
    val ListaEgoHiri= arrayOf("Madril","Bartzelona","Valentzia")
    var noSele = true
    var arropaGus: String =""
    var egoitzaHi: String =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_erregistro)

        btnErre=findViewById(R.id.btnErre)
        btnBuel=findViewById(R.id.btnBuelta)
        izena=findViewById(R.id.edIzena)
        abizena=findViewById(R.id.edAbizena)
        Pasa=findViewById(R.id.edPass)
        ema=findViewById(R.id.edEmail)
        spArrogus=findViewById(R.id.spArropaGus)
        spEgoHi=findViewById(R.id.spEgoHi)
        chAlAlgo=findViewById(R.id.chAlgoAl)
        chAlPol=findViewById(R.id.chPoAL)




        val adapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,ListaArroGus)
        spArrogus.adapter=adapter


        val adapter2= ArrayAdapter(this,android.R.layout.simple_spinner_item,ListaEgoHiri)
        spEgoHi.adapter=adapter2



        btnBuel.setOnClickListener {
            finish()
        }


        btnErre.setOnClickListener {
            spinnerEmaitzaEman()
            GordeBD()


        }


    }
    // datu basera gordetzeko funtzioa
    fun GordeBD(){



       val admin = AdminSQLiteOpenHelper(this,"administracion",null,1)
      val bd=admin.writableDatabase

       val nom: String=izena.text.toString()
        val abizena: String= abizena.text.toString()
        val pasahitza: String = Pasa.text.toString()
        val email: String =ema.text.toString()
        var listaChecks =ArrayList<String>()



        if(chAlPol.isChecked){

           listaChecks.add("poliesterrari alergikoa")

        }
        if(chAlAlgo.isChecked){
            listaChecks.add("Algodoiari alergikoa")
        }

        if( nom=="" || abizena=="" || pasahitza=="" || email==""){

            noSele=true

        }

        //datuak hartu eta ondoren datu basera sartuko dugu

        if(!noSele){
        val registro= ContentValues()
        registro.put("izena",nom)
        registro.put("abizena",abizena) 
        registro.put("email",email)
        registro.put("pasahitza",pasahitza)
        registro.put("arropaGustukoena",arropaGus)
        registro.put("egoitzaHiria",egoitzaHi)
        var respuestaConComas=listaChecks.joinToString(",");
        registro.put("jakinarazpenIrizpideak",respuestaConComas)

        bd.insert("usuarios",null, registro)
        bd.close()
            toastAgertu("datu basean datuak gorde dira")
            val i= Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        if(noSele){
            toastAgertu("Kampo Guztiak ez dira sartu")
        }




    }









   fun toastAgertu(mezua : String){
       val t = Toast.makeText(this,mezua, Toast.LENGTH_SHORT)
       t.show()

   }

    fun spinnerEmaitzaEman() {
        spArrogus.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, posicion: Int, id: Long) {
                val seleItem = ListaArroGus[posicion]
                noSele=false

                when (seleItem){

                    "Kamiseta"-> arropaGus="Kamiseta"

                    "Praka"-> arropaGus="Praka"

                    "Jaka"-> arropaGus="Jaka"

                    "Abrigoa"-> arropaGus="Abrigoa"


                    else -> arropaGus=""
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                noSele=true

            }


        }

        spEgoHi.onItemSelectedListener= object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, posicion: Int, id: Long) {
                val seleItem = ListaEgoHiri[posicion]
                noSele=false
                when (seleItem){

                    "Madril"-> egoitzaHi="Madril"

                    "Bartzelona"-> egoitzaHi="Bartzelona"

                    "Valentzia"-> egoitzaHi="Valentzia"



                    else -> egoitzaHi=""
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                noSele=true
            }


        }
    }
}