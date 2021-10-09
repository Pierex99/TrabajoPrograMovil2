package pe.edu.ulima.pm.cookiemaker.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookiemaker.R
import pe.edu.ulima.pm.cookiemaker.adapter.IngredienteListAdapter
import pe.edu.ulima.pm.cookiemaker.model.Ingrediente
import pe.edu.ulima.pm.cookiemaker.model.Receta
import pe.edu.ulima.pm.cookiemaker.model.RecetasManager

class RegistrarRecetaFragment(val ingredientes: ArrayList<Ingrediente>) : Fragment(){

    interface ComunicadorFragments {
        fun devolverNombreReceta(dato: String)
    }

    private var activityContenedora : ComunicadorFragments? = null

    interface OnBtnsClicked {
        fun onClickBtnIngrediente(receta: Receta?)
    }

    private var listener : OnBtnsClicked? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)

        listener = context as? OnBtnsClicked
        activityContenedora = context as? ComunicadorFragments
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_registrar_receta, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnGuardar : Button = view.findViewById(R.id.btnGuardar)
        btnGuardar.setOnClickListener{
            val et : EditText = view.findViewById(R.id.tviNombreReceta)
            activityContenedora?.devolverNombreReceta(et.text.toString())
        }

        //obtener boton ingredientes
        val btnIngredientes : Button = view.findViewById(R.id.btnIngredientes)
        btnIngredientes.setOnClickListener{
            //cambiar a fragment SeleccionarIngredienteFragment
            //(activity as MainActivity).cambiarRegistrarRecetaFragment()
            listener?.onClickBtnIngrediente(null) //falta agarrar receta
        }

        //obtener recycler view ingrediente
        val rviIngredientes = view.findViewById<RecyclerView>(R.id.rviIngredientes)
        //adapter
        rviIngredientes.adapter = IngredienteListAdapter(
            ingredientes,
            this
        ) { ingrediente: Ingrediente ->
            Log.i("IngredientesFragment", ingrediente.name)
        }


    }
}