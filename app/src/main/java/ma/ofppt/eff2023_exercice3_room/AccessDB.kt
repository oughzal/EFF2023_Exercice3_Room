package ma.ofppt.eff2023_exercice3_room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Vente::class], version = 1)
abstract class AccessDB : RoomDatabase() {

    abstract fun venteDao(): VenteDao

    companion object {
        @Volatile
        private var INSTANCE: AccessDB? = null

        fun getInstance(context: Context): AccessDB {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AccessDB::class.java,
                    "db_vente"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}