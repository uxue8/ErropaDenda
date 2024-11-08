package com.example.erropadenda

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContentView(R.layout.activity_main)


    }

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