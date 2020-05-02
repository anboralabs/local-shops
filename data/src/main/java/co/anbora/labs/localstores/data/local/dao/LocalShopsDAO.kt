package co.anbora.labs.localstores.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.anbora.labs.localstores.data.local.model.LocalShopVO
import kotlinx.coroutines.flow.Flow

@Dao
interface LocalShopsDAO {

    /**
     * Inserts [shops] into the [LocalShopVO.TABLE_NAME] table.
     * Duplicate values are replaced in the table.
     * @param shops LocalShopVO
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(shops: List<LocalShopVO>)

    /**
     * Fetches all the local shops from the [LocalShopVO.TABLE_NAME] table.
     * @return [Flow]
     */
    @Query("SELECT * FROM ${LocalShopVO.TABLE_NAME}")
    fun getAll(): Flow<List<LocalShopVO>>

    /**
     * Fetches all the local shops from the [LocalShopVO.TABLE_NAME] table by category.
     * @param categoryId String, category identifier
     * @return [Flow]
     */
    @Query("SELECT * FROM ${LocalShopVO.TABLE_NAME} WHERE ${LocalShopVO.COLUMN_CATEGORY_ID} = :categoryId")
    fun getAllBy(categoryId: String): Flow<List<LocalShopVO>>
}