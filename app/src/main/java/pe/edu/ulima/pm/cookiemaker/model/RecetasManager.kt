package pe.edu.ulima.pm.cookiemaker.model

import pe.edu.ulima.pm.cookiemaker.R

class RecetasManager {

    private val mIngredientes = arrayListOf<Ingrediente>()
    private val mRecetas = arrayListOf<Receta>()

    init {
        mIngredientes.add(Ingrediente("Mantequilla"))
        mIngredientes.add(Ingrediente("Azucar"))
        mIngredientes.add(Ingrediente("Harina"))
        mIngredientes.add(Ingrediente("Vainilla"))
        mIngredientes.add(Ingrediente("Polvo de Hornear"))
    }

    companion object {
        private var instance : RecetasManager? = null
    }

    fun getInstance() : RecetasManager {
        if (instance == null) {
            instance = RecetasManager()
        }
        return instance!!
    }

    fun getRecetas(): List<Receta> {
        mRecetas.add(Receta(1, "Galletas con chocochispas","Piero", R.drawable.galletas1))
        mRecetas.add(Receta(2, "Galletas de mantequilla","Bruno", R.drawable.galletas2))
        mRecetas.add(Receta(3, "Galletas con mermelada","Juan", R.drawable.galletas3))
        mRecetas.add(Receta(4, "Choco-galletas felices","Paloma", R.drawable.galletas4))

        return mRecetas
    }
    fun addReceta(receta : Receta) {
        mRecetas.add(receta)
    }
    fun getReceta(id : Int) : Receta? {
        // Debe implementarlo !!!
        return null
    }

    fun getIngredientes() : List<Ingrediente> {
        return mIngredientes
    }

}