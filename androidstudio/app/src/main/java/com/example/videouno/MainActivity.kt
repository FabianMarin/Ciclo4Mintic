package com.example.videouno

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    private var edtUsername: EditText? = null
    private var edtPassword: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.my_toolbar))


        //edtUsername = findViewById(R.id.edtUsername)
        //edtPassword = findViewById(R.id.edtPassword)
    }

    fun onlogin(botonlogin: View){
        var username: String = edtUsername!! .text.toString()
        var password: String = edtPassword!! .text.toString()
        if (username == "cesar" && password == "123"){
            val positiveButtonClick = {dialog: DialogInterface, which: Int->
                val intento = Intent (this, WelcomeActivity::class.java)
                startActivity(intento)
            }
            val negativeButtonClick= {_:DialogInterface, _: Int->
                Toast.makeText(this, "CANCELED", Toast.LENGTH_SHORT).show()


            }

            val dialog = AlertDialog.Builder(this)
                .setTitle("Titulo del dialogo")
                .setMessage("User:" + edtUsername!!.text.toString())
                .setPositiveButton("OK", positiveButtonClick)
                .setNegativeButton("CANCEL", negativeButtonClick)
            dialog.create()
            dialog.show()
        }else{
            val dialog = AlertDialog.Builder(this).setTitle("ERROR!")
                .setMessage("INVALID username or password").create().show()
        }

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId) {
        R.id.action_serarch->{
            Toast.makeText(this, R.string.action_search, Toast.LENGTH_LONG).show()
            true
        }

        R.id.action_settings->{
            Toast.makeText(this, R.string.action_settings, Toast.LENGTH_LONG).show()
            true
        }
        R.id.action_logout->{
            Toast.makeText(this, R.string.action_logout, Toast.LENGTH_LONG).show()
            true
        }
        else->{
            super.onOptionsItemSelected(item)
        }

    }
}