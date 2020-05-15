package co.anbora.labs.localstores.data.local.inventory

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import co.anbora.labs.localstores.data.local.dao.CategoryDAO
import co.anbora.labs.localstores.data.local.dao.LocalShopsDAO
import co.anbora.labs.localstores.data.local.dao.ShopImagesDAO
import co.anbora.labs.localstores.data.local.migrations.DatabaseMigrations
import co.anbora.labs.localstores.data.local.model.CategoryVO
import co.anbora.labs.localstores.data.local.model.LocalShopVO
import co.anbora.labs.localstores.data.local.model.ShopImagesVO
import co.anbora.labs.spatia.builder.SpatiaRoom

@Database(
    entities = [CategoryVO::class, LocalShopVO::class, ShopImagesVO::class],
    version = DatabaseMigrations.DB_VERSION
)
abstract class AppDatabase :RoomDatabase() {

    abstract fun getCategoryDao(): CategoryDAO

    abstract fun getLocalShopsDao(): LocalShopsDAO

    abstract fun getShopImagesDao(): ShopImagesDAO

    companion object {
        private const val DB_NAME = "local_database"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = SpatiaRoom.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .addMigrations(*DatabaseMigrations.MIGRATIONS)
                    .build()

                INSTANCE = instance
                return instance
            }
        }
    }
}