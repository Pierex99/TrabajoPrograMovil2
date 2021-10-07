package pe.edu.ulima.pm.cookiemaker.model

class RecetasManager {
    fun getRecetas(): List<Receta> {
        val recetas = arrayListOf<Receta>()
        recetas.add(Receta(1, "Galletas de mantequilla",3.00f, ""))
        recetas.add(Receta(2, "Galletas crujientes de almendras",3.00f, ""))
        return recetas
    }
}