package pe.edu.ulima.pm.cookiemaker.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookiemaker.R
import pe.edu.ulima.pm.cookiemaker.adapter.IngredienteListAdapter
import pe.edu.ulima.pm.cookiemaker.adapter.RecetaListAdapter
import pe.edu.ulima.pm.cookiemaker.model.Ingrediente
import pe.edu.ulima.pm.cookiemaker.model.Receta
import pe.edu.ulima.pm.cookiemaker.model.RecetasManager

class SeleccionarIngredienteFragment : Fragment(){

    private var listenerItem  : OnIngredienteSelectedListener? = null

    interface OnIngredienteSelectedListener {
        fun onSelectIngrediente(ingrediente: Ingrediente)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listenerItem = context as? OnIngredienteSelectedListener
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
        return inflater.inflate(R.layout.fragment_seleccionar_ingrediente, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //obtener recycler view ingrediente
        val rviIngredientes = view.findViewById<RecyclerView>(R.id.rviIngredientes)
        //adapter
        rviIngredientes.adapter = IngredienteListAdapter(
            RecetasManager().getIngredientes(),
            this,
         { ingrediente: Ingrediente ->
            Log.i("IngredientesFragment", ingrediente.name)
            listenerItem?.onSelectIngrediente(ingrediente)
        }
        )

    }
}