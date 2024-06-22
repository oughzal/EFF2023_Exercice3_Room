package ma.ofppt.eff2023_exercice3_room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Vente(
    @PrimaryKey(autoGenerate = true)
    val numV: Int,
    val typeCarburant: String,
    val qteVendue: Int
)
