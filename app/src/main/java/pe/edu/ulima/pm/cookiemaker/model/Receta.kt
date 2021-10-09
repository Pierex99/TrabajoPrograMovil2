package pe.edu.ulima.pm.cookiemaker.model

data class Receta(
    val id : Long,
    val name : String,
    val user : String,
    val url : Int,
    val ingredientes : List<Ingrediente> = arrayListOf()
)