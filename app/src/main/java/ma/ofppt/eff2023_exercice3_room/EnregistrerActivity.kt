package ma.ofppt.eff2023_exercice3_room

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class EnregistrerActivity : AppCompatActivity() {
    lateinit var numV: TextView
    lateinit var typeCarburant: EditText
    lateinit var qteVendue: EditText
    lateinit var btnEnregistrer: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enregister)
        numV = findViewById(R.id.numV)
        typeCarburant = findViewById(R.id.typeCarburant)
        qteVendue = findViewById(R.id.qteVendue)
        btnEnregistrer = findViewById(R.id.btnEnregistrer)
        val num = intent.getIntExtra("numV", 0)
        numV.text = num.toString()

        btnEnregistrer.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Confirmation")
                .setMessage("Voulez-vous vraiment ajouter cette vente ?")
                .setPositiveButton("Oui") { dialog, which ->
                    val num : Int = numV.text.toString().toInt()
                    val type : String = typeCarburant.text.toString()
                    val qteVendue : Int = qteVendue.text.toString().toInt()
                    val vente = Vente(num,type,qteVendue)
                    lifecycleScope.launch {
                        val venteDao = AccessDB.getInstance(applicationContext).venteDao()
                        venteDao.ajouterVente(vente)
                    }
                }
                .setNegativeButton("Non", null)
                .show()

        }


    }
}