package pe.edu.ulima.pm.cookiemaker.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import pe.edu.ulima.pm.cookiemaker.MainActivity
import pe.edu.ulima.pm.cookiemaker.R


class RecetasFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

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
            (activity as MainActivity).cambiarRegistrarRecetasFragment()
        }
    }
}