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
import pe.edu.ulima.pm.cookiemaker.model.RecetasManager


class RecetasFragment : Fragment() {

    interface OnMenuClicked {
        fun onClick(menuName : String)
    }

    private var listener : OnMenuClicked? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as? OnMenuClicked
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
        rviRecetas.adapter = RecetaListAdapter(RecetasManager().getRecetas())
    }
}