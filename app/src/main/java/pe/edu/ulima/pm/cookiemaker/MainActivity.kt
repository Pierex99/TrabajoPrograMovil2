package pe.edu.ulima.pm.cookiemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.cookiemaker.fragments.RecetasFragment
import pe.edu.ulima.pm.cookiemaker.fragments.RegistrarRecetaFragment

class MainActivity : AppCompatActivity(), RecetasFragment.OnMenuClicked {

    private val fragments = mutableListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments.add(RegistrarRecetaFragment())

        //transaccion
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContent, RecetasFragment())
        //terminar transaccion
        ft.commit()



    }

    private fun changeRegistrarRecetasFragment(){
        val fragment = fragments[0]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)
        //añadir a pila de cosas que hacer
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onClick(menuName: String) {
        if (menuName == "registrarReceta"){
            changeRegistrarRecetasFragment()
        }
    }
}