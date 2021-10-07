package pe.edu.ulima.pm.cookiemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import pe.edu.ulima.pm.cookiemaker.fragments.RecetasFragment
import pe.edu.ulima.pm.cookiemaker.fragments.RegistrarRecetaFragment

class MainActivity : AppCompatActivity(), RecetasFragment.OnMenuClicked {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = RecetasFragment()
        //transaccion
        val ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.flaContent, fragment)
        //terminar transaccion
        ft.commit()



    }

    private fun changeRegistrarRecetasFragment(){
        val fragment = RegistrarRecetaFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onClick(menuName: String) {
        if (menuName == "registrarReceta"){
            changeRegistrarRecetasFragment()
        }
    }
}