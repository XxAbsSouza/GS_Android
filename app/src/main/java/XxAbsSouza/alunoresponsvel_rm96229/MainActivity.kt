import XxAbsSouza.alunoresponsvel_rm96229.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var dicaAdapter: DicaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializa o RecyclerView
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Cria uma lista de dicas
        val dicas = listOf(
            Dica("Use lâmpadas LED", "As lâmpadas LED consomem até 80% menos energia do que as convencionais."),
            Dica("Desligue aparelhos em stand-by", "Evite deixar dispositivos em stand-by para economizar energia."),
            Dica("Separe o lixo reciclável", "Faça a separação correta dos resíduos para facilitar a reciclagem."),
            Dica("Utilize a água de forma consciente", "Feche a torneira enquanto escova os dentes ou lava a louça."),
            Dica("Plante árvores", "O plantio de árvores ajuda a melhorar a qualidade do ar e reduzir a poluição."),
            Dica("Compre produtos sustentáveis", "Prefira produtos ecológicos, feitos com materiais recicláveis e de baixo impacto ambiental.")
        )

        // Configura o Adapter para o RecyclerView
        dicaAdapter = DicaAdapter(dicas)
        recyclerView.adapter = dicaAdapter
    }
}
