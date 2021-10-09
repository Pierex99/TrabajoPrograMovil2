package pe.edu.ulima.pm.cookiemaker.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookiemaker.MainActivity
import pe.edu.ulima.pm.cookiemaker.R
import pe.edu.ulima.pm.cookiemaker.adapter.RecetaListAdapter
import pe.edu.ulima.pm.cookiemaker.model.Receta
import pe.edu.ulima.pm.cookiemaker.model.RecetasManager


class RecetasFragment : Fragment() {
    //interfaz para poder reciclar el fragment y cualquier click en cualquiera de sus componentes
    interface OnMenuClicked {
        fun onClick(menuName : String)
    }
    interface  OnRecetaSelectedListener {
        fun onSelect(receta : Receta)
    }

    //listener para el click
    private var listener : OnMenuClicked? = null
    private var listenerItem  : OnRecetaSelectedListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as? OnMenuClicked
        listenerItem = context as? OnRecetaSelectedListener
    }

    /*
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    */

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_recetas, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //añadir receta (si hay en arguments)

        /*
        if (arguments != null) {
            val nameReceta = requireArguments().getString("nameReceta")
            println("prueba2 = "+nameReceta)
            //addReceta
            var newReceta = Receta(5, nameReceta,"Piero", R.drawable.galletas1)
            RecetasManager().getInstance().addReceta(newReceta)
        }
         */

        //obtener boton agregar
        val btnAgregar : Button = view.findViewById(R.id.btnAgregar)
        btnAgregar.setOnClickListener{
            //cambiar a fragment RegistrarRecetasFragment
            //(activity as MainActivity).cambiarRegistrarRecetaFragment()
            listener?.onClick("registrarReceta")
        }

        //obtener recycler view
        val rviRecetas = view.findViewById<RecyclerView>(R.id.rviRecetas)
        //adapter
        rviRecetas.adapter = RecetaListAdapter(
            RecetasManager().getInstance().getRecetas(),
            this
        ) { receta: Receta ->
            Log.i("RecetasFragment", receta.name!!)
            listenerItem?.onSelect(receta)
        }
    }
}