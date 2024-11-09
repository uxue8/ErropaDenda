import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.erropadenda.Erropa
import com.example.erropadenda.R

class ItemAdapter(
    private val erropaList: ArrayList<Erropa>,
    private val onItemClicked: (Erropa) -> Unit
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    private var selectedPosition = RecyclerView.NO_POSITION  // Almacena la posición seleccionada

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewIzena: TextView = itemView.findViewById(R.id.itemIzena)
        val textViewMota: TextView = itemView.findViewById(R.id.itemMota)
        val textViewPrezioa: TextView = itemView.findViewById(R.id.itemPrezioa)


        fun bind(erropa: Erropa, isSelected: Boolean) {
            textViewIzena.text = erropa.izena
            textViewMota.text = erropa.mota
            textViewPrezioa.text = erropa.prezioa
            // Cambia el fondo según si está seleccionado o no
            itemView.setBackgroundColor(
                if (isSelected) itemView.context.getColor(R.color.colorSelected)
                else itemView.context.getColor(R.color.colorUnselected)
            )

            // Configura el listener de clic
            itemView.setOnClickListener {
                // Actualiza el índice seleccionado y notifica el cambio
                val previousPosition = selectedPosition
                selectedPosition = bindingAdapterPosition

                // Notificar solo las posiciones cambiadas
                notifyItemChanged(previousPosition)
                notifyItemChanged(selectedPosition)

                // Llama al listener de clic
                onItemClicked(erropa)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val erropa = erropaList[position]
        holder.bind(erropa, position == selectedPosition)
    }

    override fun getItemCount() = erropaList.size
}
