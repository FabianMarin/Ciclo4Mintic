package com.kotlindevs.kdmarketf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class FragmentosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragmentos)
        if (savedInstanceState==null){
            supportFragmentManager.beginTransaction().setReorderingAllowed(true)
                .add(R.id.frmContaineracfs, ProductsActivity::class.java,null,"ProductosActivity").commit()
        }
    }
}