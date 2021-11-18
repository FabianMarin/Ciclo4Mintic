package com.kotlindevs.kdmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class LoginActivity : AppCompatActivity() {
    private var edtUsername: EditText?=null
    private var edtPassword: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(findViewById(R.id.tollb1))

        edtUsername=findViewById(R.id.edittxtuserlogin)
        edtPassword=findViewById(R.id.edittxtpasslogin)
    }

    fun validLogin(view: android.view.View) {
        var username:String=edtUsername!!.text.toString()
        var password:String=edtPassword!!.text.toString()
        if(username == "elpepe" && password == "123"){
            val intento= Intent(this, WelcomeActivity::class.java)
            startActivity(intento)
            Toast.makeText(applicationContext,resources.getString(R.string.Welcome), Toast.LENGTH_LONG).show()
        }
        else{
            val dialog= AlertDialog.Builder(this).setTitle("Error")
                .setMessage(resources.getString(R.string.ErInvLogin)).create().show()
        }
    }

    fun onRegister(view: android.view.View) {
        val intentreg= Intent(this, RegisterActivity::class.java)
        startActivity(intentreg)
    }

    fun onLogin(view: android.view.View) {
        val intentreg= Intent(this, LoginActivity::class.java)
        startActivity(intentreg)
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_login_activity,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId){
        R.id.action_home->{
            val intentlog= Intent(this, MainActivity::class.java)
            startActivity(intentlog)
            true
        }
        R.id.action_register->{
            val intentreg= Intent(this, RegisterActivity::class.java)
            startActivity(intentreg)
            true
        }
        R.id.action_backmenu->{
            val intentohom= Intent(this, MainActivity::class.java)
            startActivity(intentohom)
            true
        }
        else->{
            super.onOptionsItemSelected(item)
        }
    }
}