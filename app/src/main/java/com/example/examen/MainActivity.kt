package com.example.examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity(), FragmentActionListener {
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

        val fragmentoCategorias = CategoriasFragment()

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

    override fun onClickBotonFragment(titulo: String) {
        TODO("Not yet implemented")
    }
}