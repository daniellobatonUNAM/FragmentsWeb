package com.example.examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), AdaptadorCategorias.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*btn1 = findViewById(R.id.btnUno)
        btn2 = findViewById(R.id.btnDos)

        btn1.setOnClickListener {
            val nuevoFragmento = FragmentUno()
            val args = Bundle()
            args.putString("ARG_1", "Valor 1")
            nuevoFragmento.arguments = args
            remplazarFragmento(nuevoFragmento)
        }
        btn2.setOnClickListener {
            val nuevoFragmento = FragmentDos()
            val args = Bundle()
            args.putString("ARG_2", "Valor 2")
            nuevoFragmento.arguments = args
            remplazarFragmento(nuevoFragmento)
        }*/

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


        val fragmentoOpciones = OpcionesFragment()

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
        Log.d("Listener", "SIIIIIUUUUUUUUUUUUUUU")
        Log.d("Listener2", "Nombre Categoría: " + item.title)
    }
}