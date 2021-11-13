package com.kotlindevs.kdmarket

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        setSupportActionBar(findViewById(R.id.tollb1))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean = when (item.itemId){
        R.id.action_login->{
            val intento= Intent(this, LoginActivity::class.java)
            startActivity(intento)
            true
        }
        R.id.action_terms->{
            val newFragment = TermsFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frmtMain1, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            true
        }
        R.id.action_help->{
            val newFragment = HomeHelpFragment()
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frmtMain1, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
            true
        }
        else->{
            super.onOptionsItemSelected(item)
        }
    }
}