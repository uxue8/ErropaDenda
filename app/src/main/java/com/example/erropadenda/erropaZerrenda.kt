package com.example.erropadenda

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class erropaZerrenda : AppCompatActivity() {

        lateinit var     btnBuelta: Button
        lateinit var  recyListErro: RecyclerView
        lateinit var  erropaLista: List<Erropa>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      //  enableEdgeToEdge()
        setContentView(R.layout.activity_erropa_zerrenda)
       // ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
       //     val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
      //      v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
      //      insets
      //  }
        btnBuelta=findViewById(R.id.btnBueltatu)
        recyListErro=findViewById(R.id.recyErro)

        erropaerakutsi()

        // Configurar el RecyclerView
        recyListErro=findViewById(R.id.recyErro)
        recyListErro.layoutManager = LinearLayoutManager(this)
        recyListErro.adapter = ItemAdapter(erropaLista)
    }

    fun erropaerakutsi(){
        val admin = AdminSQLiteOpenHelper(this,"administracion",null,1)
        val bd=admin.writableDatabase
        val lerroa =bd.rawQuery("select * from productos",null)
        if(lerroa.moveToFirst()){

            while(lerroa.moveToNext()){
                var erropak = Erropa(lerroa.getInt(0),lerroa.getString(1),lerroa.getString(2),lerroa.getString(3),lerroa.getString(4),lerroa.getString(5),lerroa.getString(6))
                erropaLista= listOf(erropak)
            }
        }
    }
}


