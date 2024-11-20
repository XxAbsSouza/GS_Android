package XxAbsSouza.alunoresponsvel_rm96229
import DicasAdapter
import XxAbsSouza.alunoresponsvel_rm96229.viewmodel.DicasViewModel
import XxAbsSouza.alunoresponsvel_rm96229.viewmodel.DicasViewModelFactory
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: DicasViewModel

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = "Lista de Compras"

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        val dicasAdapter = DicasAdapter { dica ->
            viewModel.removeDica(dica)
        }
        recyclerView.adapter = dicasAdapter

        val button = findViewById<Button>(R.id.button)
        val editText = findViewById<EditText>(R.id.editText)

        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }

            // Adiciona o item ao ViewModel e limpa o campo de texto.
            viewModel.addDica(editText.text.toString(),editText.text.toString())
            editText.text.clear()
        }

        // Cria uma nova fábrica para o ViewModel.
        val viewModelFactory = DicasViewModelFactory(application)
        // Obtém uma instância do ViewModel.
        viewModel = ViewModelProvider(this, viewModelFactory).get(DicasViewModel::class.java)

        // Observa as mudanças na lista de itens e atualiza o adaptador quando a lista muda.
        viewModel.dicasLiveData.observe(this) { dicas ->
            dicasAdapter.updateDicas(dicas)
        }
    }
}
