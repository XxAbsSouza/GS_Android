import XxAbsSouza.alunoresponsvel_rm96229.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class DicasAdapter(private val onDicaRemoved: (DicaModel) -> Unit) : RecyclerView.Adapter<DicasAdapter.DicaViewHolder>() {
    private var dicas = listOf<DicaModel>()
    inner class DicaViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textView = view.findViewById<TextView>(R.id.textViewItem)
        val button = view.findViewById<ImageButton>(R.id.imageButton)

        fun bind(dica: DicaModel) {
            textView.text = dica.titulo
            button.setOnClickListener {
                onDicaRemoved(dica)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DicaViewHolder {
        // Infla o layout do item.
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.dica_layout, parent, false)
        // Cria e retorna um novo ViewHolder.
        return DicaViewHolder(view)
    }

    override fun onBindViewHolder(holder: DicaViewHolder, position: Int) {
        val dica = dicas[position]
        holder.bind(dica)
    }

    override fun getItemCount(): Int = dicas.size

    fun updateDicas(newDicas: List<DicaModel>) {
        // Atualiza a lista de itens.
        dicas = newDicas
        // Notifica o RecyclerView que os dados mudaram.
        notifyDataSetChanged()
    }
}
