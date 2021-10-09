package pe.edu.ulima.pm.cookiemaker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookiemaker.R
import pe.edu.ulima.pm.cookiemaker.model.Receta

class RecetaListAdapter(
    private val recetaList : List<Receta>,
    private val fragment : Fragment,
    private val listener : (Receta) -> Unit
        ) : //listener para asignar click a cada item //unit = void
    RecyclerView.Adapter<RecetaListAdapter.ViewHolder>(){

        // ViewHolder: clase que va a representar un item visual de nuestra lista
        class ViewHolder(
                view : View, val listener : (Receta) -> Unit,
                val recetaList: List<Receta>) : RecyclerView.ViewHolder(view), View.OnClickListener {

            val iviRecetaImage : ImageView
            val tviRecetaName : TextView
            val tviRecetaUser : TextView

            init {
                iviRecetaImage = view.findViewById(R.id.iviRecetaImage)
                tviRecetaName = view.findViewById(R.id.tviRecetaName)
                tviRecetaUser = view.findViewById(R.id.tviRecetaUser)
                view.setOnClickListener(this)
            }

            override fun onClick(v: View?) {
                listener(recetaList[adapterPosition])
            }
        }
    //metodo para instanciar viewholders
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //trae el item_receta a la variable view
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_receta, parent, false)

        //lleva el view a la clase ViewHolder
        val viewHolder = ViewHolder(view, listener, recetaList)
        return viewHolder
    }
    //asignar lista de recetas a los elementos del recycler view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Picasso.get().load("http://i.imgur.com/DvpvklR.png").into(holder.iviRecetaImage)

        holder.iviRecetaImage.setImageResource(recetaList[position].url)
        holder.tviRecetaName.text = recetaList[position].name
        holder.tviRecetaUser.text = recetaList[position].user
    }

    override fun getItemCount(): Int {
        return recetaList.size
    }
}