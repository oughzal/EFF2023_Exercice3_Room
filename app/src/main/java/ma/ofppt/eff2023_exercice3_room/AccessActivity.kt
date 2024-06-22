package ma.ofppt.eff2023_exercice3_room

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class AccessActivity : AppCompatActivity() {
    lateinit var btnValider: Button
    lateinit var numV: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        numV = findViewById(R.id.txtNum)
        btnValider = findViewById(R.id.btnValider)

        btnValider.setOnClickListener {

                val numV = numV.text.toString().toInt()
            GlobalScope.launch(Dispatchers.IO) {
                val venteDao = AccessDB.getInstance(applicationContext).venteDao()
                val vente = venteDao.rechercher(numV)
                if (vente == null) {
                    val intent = Intent(this@AccessActivity, EnregistrerActivity::class.java)
                    intent.putExtra("numV", numV)
                    startActivity(intent)
                }
            }
        }


    }
}