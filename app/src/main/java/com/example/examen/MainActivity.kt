package com.example.examen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), AdaptadorCategorias.OnItemClickListener, AdaptadorOpciones.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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

    fun remplazarFragmento(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.apply {
            replace(R.id.fragmentContainer2, fragment)
            addToBackStack(null)
            commit()
        }
    }

    override fun onItemClick1(item: ItemCategoria) {

        var nombreSeccion = item.title

        actualizaSegundoFragment(nombreSeccion)
    }

    override fun onItemClick2(item: ItemOpcion) {
        Log.d("Click 2", "Está funcionando el segundo fragment")
        Log.d("Click 2", "Opción: " + item.title + "\nURL: " + item.url)

        inicializarWebView(item.url)
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
                Log.d("When1", "Ropa")
                opcion1 = "PULL&BEAR"
                url1 = "https://www.pullandbear.com"
                opcion2 = "Zara"
                url2 = "https://www.zara.com"
                opcion3 = "Hugo Boss"
                url3 = "https://www.hugoboss.com"
            }
            "Electrónica" -> {
                Log.d("When2", "Electrónica")
                opcion1 = "Steren"
                url1 = "https://www.steren.com.mx"
                opcion2 = "Mobo"
                url2 = "https://www.mobo.com.mx"
                opcion3 = "Radioshack"
                url3 = "https://www.radioshack.com.mx"
            }
            "Comestibles" -> {
                Log.d("When3", "Comestibles")
                opcion1 = "Sushi Roll"
                url1 = "https://www.sushiroll.com.mx"
                opcion2 = "Crepe Corner"
                url2 = "https://www.crepecorners.com"
                opcion3 = "Chilli's"
                url3 = "https://www.chillis.com.mx"
            }
            "Deportes" -> {
                Log.d("When4", "Deportes")
                opcion1 = "Adidas"
                url1 = "https://www.adidas.mx"
                opcion2 = "Nike"
                url2 = "https://www.nike.com"
                opcion3 = "Puma"
                url3 = "https://mx.puma.com"
            }
            "Hogar" -> {
                Log.d("When5", "Hogar")
                opcion1 = "Home Depot"
                url1 = "https://www.homedepot.com.mx"
                opcion2 = "Perfect-Home"
                url2 = "https://www.perfect-home.mx"
                opcion3 = "Redlemon"
                url3 = "https://www.redlemon.com.mx"
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

    fun inicializarWebView(url: String){

        val intent = Intent(this, WebActivity::class.java)

        intent.putExtra("url", url)

        startActivity(intent)
    }


}