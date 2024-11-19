import XxAbsSouza.alunoresponsvel_rm96229.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DicaAdapter(private val dicasList: List<Dica>) : RecyclerView.Adapter<DicaAdapter.DicaViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DicaViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_dica, parent, false)
        return DicaViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DicaViewHolder, position: Int) {
        val dica = dicasList[position]
        holder.titulo.text = dica.titulo
        holder.descricao.text = dica.descricao
    }

    override fun getItemCount() = dicasList.size

    // ViewHolder para o item
    class DicaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titulo: TextView = view.findViewById(R.id.tituloDica)
        val descricao: TextView = view.findViewById(R.id.descricaoDica)
    }
}
