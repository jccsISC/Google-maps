package com.jccsisc.ubicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jccsisc.ubicacion.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var mBiding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBiding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBiding.root)

        initElements()
    }
}