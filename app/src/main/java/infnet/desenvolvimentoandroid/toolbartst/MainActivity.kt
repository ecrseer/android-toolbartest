package br.pro.aguiar.ep7produtos

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.appcompat.widget.Toolbar
import infnet.desenvolvimentoandroid.toolbartst.R

class MainActivity : AppCompatActivity() {
    lateinit var mToolbar: Toolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mToolbar = findViewById(R.id.toolbar)
    }

    override fun onStart() {
        super.onStart()
        with(mToolbar as Toolbar){

            setSupportActionBar(mToolbar)
        }
    }



}