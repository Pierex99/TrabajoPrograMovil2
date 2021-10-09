package pe.edu.ulima.pm.cookiemaker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import pe.edu.ulima.pm.cookiemaker.fragments.RecetasFragment
import pe.edu.ulima.pm.cookiemaker.fragments.RegistrarRecetaFragment
import pe.edu.ulima.pm.cookiemaker.fragments.SeleccionarIngredienteFragment
import pe.edu.ulima.pm.cookiemaker.fragments.VisualizarRecetaFragment
import pe.edu.ulima.pm.cookiemaker.model.Ingrediente
import pe.edu.ulima.pm.cookiemaker.model.Receta
import pe.edu.ulima.pm.cookiemaker.model.RecetasManager

class MainActivity : AppCompatActivity(), RecetasFragment.OnMenuClicked,
        RecetasFragment.OnRecetaSelectedListener,
        RegistrarRecetaFragment.OnBtnsClicked,
        SeleccionarIngredienteFragment.OnIngredienteSelectedListener,
        RegistrarRecetaFragment.ComunicadorFragments{

    private val fragments = mutableListOf<Fragment>()
    var ingredientes = arrayListOf<Ingrediente>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments.add(RegistrarRecetaFragment(ingredientes))
        fragments.add(VisualizarRecetaFragment())
        fragments.add(SeleccionarIngredienteFragment())

        //transaccion
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, RecetasFragment())
        //terminar transaccion
        ft.commit()

    }

    private fun changeRegistrarRecetaFragment(ingrediente: Ingrediente?){
        val fragment = fragments[0]
        val ft = supportFragmentManager.beginTransaction()

        //TODO: if ingrediente != null, agregar ingrediente
        // bundle al reves


        ft.replace(R.id.flaContent, fragment)
        //añadir a pila de cosas que hacer
        ft.addToBackStack(null)
        ft.commit()
    }

    private fun changeVisualizarRecetaFragment(receta : Receta){
        //crear bundle para enviar datos al fragment
        val bundle = Bundle()
        bundle.putString("nameReceta", receta.name)

        val fragment = fragments[1]
        val ft = supportFragmentManager.beginTransaction()

        fragment.arguments = bundle //poner el bundle en los arguments para enviar

        ft.replace(R.id.flaContent, fragment)
        //añadir a pila de cosas que hacer
        ft.addToBackStack(null)
        ft.commit()
    }

    private fun changeSeleccionarIngredienteFragment(receta: Receta?){
        val fragment = fragments[2]
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.flaContent, fragment)

        //todo: guardar y enviar receta (creo)

        //añadir a pila de cosas que hacer
        ft.addToBackStack(null)
        ft.commit()
    }

    override fun onClick(menuName: String) {
        if (menuName == "registrarReceta"){
            changeRegistrarRecetaFragment(null)
        }
    }

    override fun onClickBtnIngrediente(receta: Receta?){
        println("BOTON INGREDIENTES FUNCIONA")
        changeSeleccionarIngredienteFragment(receta)
    }

    override fun onSelect(receta: Receta) {
        changeVisualizarRecetaFragment(receta)
    }

    override fun onSelectIngrediente(ingrediente: Ingrediente){
        println("GAAAAA")
        changeRegistrarRecetaFragment(ingrediente)
    }

    override fun devolverNombreReceta(dato: String) {
        val bundle = Bundle()
        bundle.putString("nameReceta", dato)

        //agregar receta a vista addReceta()
        var nombre = intent.getBundleExtra("data")?.getString("nameUser")
        println("nombre = "+nombre)
        var newReceta = Receta(5, dato, nombre.toString(), R.drawable.galletas1)
        RecetasManager().getInstance().addReceta(newReceta)

        val fragment = fragments[1]
        val ft = supportFragmentManager.beginTransaction()

        fragment.arguments = bundle //poner el bundle en los arguments para enviar

        ft.replace(R.id.flaContent, RecetasFragment())
        //terminar transaccion
        ft.addToBackStack(null)
        ft.commit()
    }

}