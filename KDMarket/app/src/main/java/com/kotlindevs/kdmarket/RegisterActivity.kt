package com.kotlindevs.kdmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        setSupportActionBar(findViewById(R.id.tollb1))
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

    fun onRegister(view: android.view.View) {
        val intentreg= Intent(this, RegisterActivity::class.java)
        startActivity(intentreg)
    }

    fun onLogin(view: android.view.View) {
        val intentreg= Intent(this, LoginActivity::class.java)
        startActivity(intentreg)
    }

}