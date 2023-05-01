package com.example.examen

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), AdaptadorCategorias.OnItemClickListener, AdaptadorOpciones.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            // Ocultar la ActionBar
            supportActionBar?.hide()
        }
        setContentView(R.layout.activity_main)

        //Primer Fragment
        var categoria1: String = getString(R.string.categoria_1)
        var categoria2: String = getString(R.string.categoria_2)
        var categoria3: String = getString(R.string.categoria_3)
        var categoria4: String = getString(R.string.categoria_4)
        var categoria5: String = getString(R.string.categoria_5)

        val listaElementos: List<ItemCategoria> = listOf(
            ItemCategoria(categoria1),
            ItemCategoria(categoria2),
            ItemCategoria(categoria3),
            ItemCategoria(categoria4),
            ItemCategoria(categoria5)
        )

        val adaptador = AdaptadorCategorias(listaElementos)
        adaptador.onItemClickListener = this

        val fragmentoCategorias = CategoriasFragment(adaptador)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer1, fragmentoCategorias)
            .commit()



        //Segundo Fragment (Sólo texto por defecto)
        val listaOpciones: List<ItemOpcion> = listOf()

        val adaptador2 = AdaptadorOpciones(listaOpciones)

        val fragmentoOpciones = OpcionesFragment(adaptador2)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainer2, fragmentoOpciones)
            .commit()

    }


    override fun onItemClick1(item: ItemCategoria) {

        var nombreSeccion = item.title

        actualizaSegundoFragment(nombreSeccion)
    }

    fun actualizaSegundoFragment(nombre: String){

        lateinit var opcion1: String
        lateinit var opcion2: String
        lateinit var opcion3: String
        lateinit var url1: String
        lateinit var url2: String
        lateinit var url3: String

        when (nombre) {
            "Ropa" -> {
                opcion1 = getString(R.string.ropa_1)
                url1 = getString(R.string.ropa_1_url)
                opcion2 = getString(R.string.ropa_2)
                url2 = getString(R.string.ropa_2_url)
                opcion3 = getString(R.string.ropa_3)
                url3 = getString(R.string.ropa_3_url)
            }
            "Electrónica" -> {
                opcion1 = getString(R.string.electronica_1)
                url1 = getString(R.string.electronica_1_url)
                opcion2 = getString(R.string.electronica_2)
                url2 = getString(R.string.electronica_2_url)
                opcion3 = getString(R.string.electronica_3)
                url3 = getString(R.string.electronica_3_url)
            }
            "Comestibles" -> {
                opcion1 = getString(R.string.comestibles_1)
                url1 = getString(R.string.comestibles_1_url)
                opcion2 = getString(R.string.comestibles_2)
                url2 = getString(R.string.comestibles_2_url)
                opcion3 = getString(R.string.comestibles_3)
                url3 = getString(R.string.comestibles_3_url)
            }
            "Deportes" -> {
                opcion1 = getString(R.string.deportes_1)
                url1 = getString(R.string.deportes_1_url)
                opcion2 = getString(R.string.deportes_2)
                url2 = getString(R.string.deportes_2_url)
                opcion3 = getString(R.string.deportes_3)
                url3 = getString(R.string.deportes_3_url)
            }
            "Hogar" -> {
                opcion1 = getString(R.string.hogar_1)
                url1 = getString(R.string.hogar_1_url)
                opcion2 = getString(R.string.hogar_2)
                url2 = getString(R.string.hogar_2_url)
                opcion3 = getString(R.string.hogar_3)
                url3 = getString(R.string.hogar_3_url)
            }
            else -> {}
        }

        val listaOpciones: List<ItemOpcion> = listOf(
            ItemOpcion(opcion1, url1),
            ItemOpcion(opcion2, url2),
            ItemOpcion(opcion3, url3),
        )

        val adaptador2a = AdaptadorOpciones(listaOpciones)

        adaptador2a.onItemClickListener = this

        val fragmentoOpciones = OpcionesFragment(adaptador2a)

        remplazarFragmento(fragmentoOpciones)

    }

    fun remplazarFragmento(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.apply {
            replace(R.id.fragmentContainer2, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onItemClick2(item: ItemOpcion) {

        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

            inicializarWebView(item.url)

        }else if(resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {

            val fragmentoWeb = WebFragment(item.url)

            // Agregar el Fragment al contenedor
            supportFragmentManager.beginTransaction()
                .add(R.id.containerWebView, fragmentoWeb)
                .commit()

        }

    }



    fun inicializarWebView(url: String){

        val intent = Intent(this, WebActivity::class.java)

        intent.putExtra("url", url)

        startActivity(intent)
    }


}