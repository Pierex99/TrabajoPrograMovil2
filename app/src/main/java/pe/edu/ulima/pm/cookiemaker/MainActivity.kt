package pe.edu.ulima.pm.cookiemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import pe.edu.ulima.pm.cookiemaker.fragments.RecetasFragment
import pe.edu.ulima.pm.cookiemaker.fragments.RegistrarRecetasFragment

class MainActivity : AppCompatActivity() {
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

    fun cambiarRegistrarRecetasFragment(){
        val fragment = RegistrarRecetasFragment()
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)

        ft.commit()
    }
}