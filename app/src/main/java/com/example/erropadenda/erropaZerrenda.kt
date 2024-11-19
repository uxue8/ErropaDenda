package com.example.erropadenda

import ItemAdapter
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class erropaZerrenda : AppCompatActivity() {


    lateinit var recyListErro: RecyclerView
    var erropaLista: ArrayList<Erropa> = ArrayList() // Inicializada como lista vacía

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_erropa_zerrenda)

        recyListErro = findViewById(R.id.recyErro)

        erropaerakutsi() // Llamada a la función que carga los datos

        //Menuaren tituloa kentzeko
        supportActionBar?.setDisplayShowTitleEnabled(false)
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
        Log.d("erropaZerrenda", "Total elementos en erropaLista: ${erropaLista.size} ")
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

    //menu
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true //super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //  return super.onOptionsItemSelected(item)
        return when (item.itemId) {


            R.id.meErroZerre->{
                val i = Intent(this, erropaZerrenda::class.java)
                startActivity(i)

                true
            }
            R.id.meErrogehi -> {
                val i = Intent(this, erropagehitu::class.java)
                startActivity(i)

                true
            }

            R.id.meIr -> {
                finish()

                true
            }

            R.id.meSaItxi -> {
                val i = Intent(this, login::class.java)
                startActivity(i)


                true
            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

}
