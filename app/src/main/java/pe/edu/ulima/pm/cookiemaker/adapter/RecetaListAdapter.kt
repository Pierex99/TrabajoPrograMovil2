package pe.edu.ulima.pm.cookiemaker.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import pe.edu.ulima.pm.cookiemaker.R
import pe.edu.ulima.pm.cookiemaker.model.Receta

class RecetaListAdapter(private val recetaList : List<Receta>) :
    RecyclerView.Adapter<RecetaListAdapter.ViewHolder>(){
        // ViewHolder: clase que va a representar un item visual de nuestra lista
        class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
            val iviRecetaImage : ImageView
            val tviRecetaName : TextView
            val tviRecetaUser : TextView

            init {
                iviRecetaImage = view.findViewById(R.id.iviRecetaImage)
                tviRecetaName = view.findViewById(R.id.tviRecetaName)
                tviRecetaUser = view.findViewById(R.id.tviRecetaUser)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_receta, parent, false)

        val viewHolder = ViewHolder(view)
        return viewHolder
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tviRecetaName.text = recetaList[position].name
        holder.tviRecetaUser.text = recetaList[position].user.toString()
    }

    override fun getItemCount(): Int {
        return recetaList.size
    }
}