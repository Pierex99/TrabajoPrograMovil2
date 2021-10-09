package pe.edu.ulima.pm.cookiemaker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookiemaker.R
import pe.edu.ulima.pm.cookiemaker.model.Ingrediente
import pe.edu.ulima.pm.cookiemaker.model.Receta

class IngredienteListAdapter (
    private val ingredienteList : List<Ingrediente>,
    private val fragment : Fragment,
    private val listener : (Ingrediente) -> Unit
    ) : //listener para asignar click a cada item //unit = void
    RecyclerView.Adapter<IngredienteListAdapter.ViewHolder>(){

        // ViewHolder: clase que va a representar un item visual de nuestra lista
        class ViewHolder(
            view : View, val listener : (Ingrediente) -> Unit,
            val ingredienteList: List<Ingrediente>) : RecyclerView.ViewHolder(view), View.OnClickListener {

            val bviIngredienteName : TextView

            init {
                bviIngredienteName = view.findViewById(R.id.bviIngredienteName)
                view.setOnClickListener(this)
            }

            override fun onClick(v: View?) {
                listener(ingredienteList[adapterPosition])
            }
        }
        //metodo para instanciar viewholders
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            //trae el item_ingrediente a la variable view
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_ingrediente, parent, false)

            //lleva el view a la clase ViewHolder
            val viewHolder = ViewHolder(view, listener, ingredienteList)
            return viewHolder
        }
        //asignar lista de recetas a los elementos del recycler view
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(holder.iviRecetaImage)

            holder.bviIngredienteName.text = ingredienteList[position].name
        }

        override fun getItemCount(): Int {
            return ingredienteList.size
        }
}