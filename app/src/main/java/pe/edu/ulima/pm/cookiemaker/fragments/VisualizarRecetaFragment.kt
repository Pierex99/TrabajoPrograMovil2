package pe.edu.ulima.pm.cookiemaker.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import pe.edu.ulima.pm.cookiemaker.R
import pe.edu.ulima.pm.cookiemaker.adapter.IngredienteListAdapter
import pe.edu.ulima.pm.cookiemaker.adapter.RecetaListAdapter
import pe.edu.ulima.pm.cookiemaker.model.Ingrediente
import pe.edu.ulima.pm.cookiemaker.model.Receta
import pe.edu.ulima.pm.cookiemaker.model.RecetasManager

class VisualizarRecetaFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_visualizar_receta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //agregar nombre e ingredientes de la receta a elementos visuales


        //obtener recycler view ingrediente
        val rviIngredientes = view.findViewById<RecyclerView>(R.id.rviIngredientes)
        //adapter
        rviIngredientes.adapter = IngredienteListAdapter(
            RecetasManager().getIngredientes(),
            this
        ) { ingrediente: Ingrediente ->
            Log.i("IngredientesFragment", ingrediente.name)
        }
    }
}