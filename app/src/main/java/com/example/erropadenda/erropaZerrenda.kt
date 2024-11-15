package com.example.erropadenda

import ItemAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class erropaZerrenda : AppCompatActivity() {

    lateinit var btnBuelta: Button
    lateinit var recyListErro: RecyclerView
    var erropaLista: ArrayList<Erropa> = ArrayList() // Inicializada como lista vacía

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_erropa_zerrenda)

        btnBuelta = findViewById(R.id.btnBueltatu)
        recyListErro = findViewById(R.id.recyErro)

        erropaerakutsi() // Llamada a la función que carga los datos

        btnBuelta.setOnClickListener{

            val i= Intent(this,MainActivity::class.java)
            startActivity(i)

        }
    }

    fun erropaerakutsi() {
        val admin = AdminSQLiteOpenHelper(this, "administracion", null, 1)
        val bd = admin.writableDatabase
        val lerroa = bd.rawQuery("select * from productos", null)

        // Limpiar la lista para evitar duplicados si esta función se llama varias veces
        erropaLista.clear()
        while (lerroa.moveToNext()) {
            val erropak = Erropa(
                lerroa.getInt(0),
                lerroa.getString(1),
                lerroa.getString(2),
                lerroa.getString(3),
                lerroa.getString(4),
                lerroa.getString(5),
                lerroa.getString(6)
            )
            erropaLista.add(erropak) // Agregar cada elemento a la lista
        }
        Log.d("erropaZerrenda", "Total elementos en erropaLista: ${erropaLista.size} y ids:{er}")
        lerroa.close()
        bd.close()

        lerroa.close()
        bd.close()

        // Configurar el RecyclerView con los datos cargados
        recyListErro.layoutManager = LinearLayoutManager(this)
        recyListErro.adapter = ItemAdapter(erropaLista) { erropa ->
           // Toast.makeText(this, "Seleccionaste: ${erropa.izena}", Toast.LENGTH_SHORT).show()

            val i= Intent(this,ProductDetailActivity::class.java)
            //cojo los datos para llevarlos a otra pagina
            i.putExtra("kodea",erropa.kodea)
            i.putExtra("izena",erropa.izena)
            i.putExtra("mota",erropa.mota)
            i.putExtra("talla",erropa.talla)
            i.putExtra("kolorea",erropa.kolorea)
            i.putExtra("prezioa",erropa.prezioa)
            i.putExtra("eskuragarritasuna",erropa.eskuragarritasuna)
            startActivity(i)
        }
    }
}
