package ma.ofppt.eff2023_exercice3_room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface VenteDao {
    @Query("SELECT * FROM Vente WHERE numV = :numV LIMIT 1")
    suspend fun rechercher(numV: Int): Vente?

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun ajouterVente(vente: Vente)
}