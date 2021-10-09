package pe.edu.ulima.pm.cookiemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.cookiemaker.fragments.RecetasFragment
import pe.edu.ulima.pm.cookiemaker.fragments.RegistrarRecetaFragment
import pe.edu.ulima.pm.cookiemaker.fragments.VisualizarRecetaFragment
import pe.edu.ulima.pm.cookiemaker.model.Receta

class MainActivity : AppCompatActivity(), RecetasFragment.OnMenuClicked,
        RecetasFragment.OnRecetaSelectedListener {

    private val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments.add(RegistrarRecetaFragment())
        fragments.add(VisualizarRecetaFragment())

        //transaccion
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, RecetasFragment())
        //terminar transaccion
        ft.commit()

    }

    private fun changeRegistrarRecetaFragment(){
        val fragment = fragments[0]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)
        //añadir a pila de cosas que hacer
        ft.addToBackStack(null)
        ft.commit()
    }

    private fun changeVisualizarRecetaFragment(receta : Receta){
        val fragment = fragments[1]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)
        //añadir a pila de cosas que hacer
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onClick(menuName: String) {
        if (menuName == "registrarReceta"){
            changeRegistrarRecetaFragment()
        }
    }

    override fun onSelect(receta: Receta) {
        changeVisualizarRecetaFragment(receta)
    }
}