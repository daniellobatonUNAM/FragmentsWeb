package com.example.examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class WebActivity: AppCompatActivity() {

    private lateinit var url: String

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web)

        val extras = intent.extras

        if (extras != null) {
            url = extras.getString("url").toString()
        }

        // Crear una instancia del Fragment
        val fragmentoWeb = WebFragment(url)

        // Agregar el Fragment al contenedor
        supportFragmentManager.beginTransaction()
            .add(R.id.containerWebView, fragmentoWeb)
            .commit()

    }
}