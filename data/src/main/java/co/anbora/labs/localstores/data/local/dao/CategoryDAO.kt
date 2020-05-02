package co.anbora.labs.localstores.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import co.anbora.labs.localstores.data.local.model.CategoryVO
import kotlinx.coroutines.flow.Flow

@Dao
interface CategoryDAO {

    /**
     * Inserts [categories] into the [CategoryVO.TABLE_NAME] table.
     * Duplicate values are replaced in the table.
     * @param categories CategoryVO
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(categories: List<CategoryVO>)

    /**
     * Fetches all the categories from the [CategoryVO.TABLE_NAME] table.
     * @return [Flow]
     */
    @Query("SELECT * FROM ${CategoryVO.TABLE_NAME}")
    fun getAll(): Flow<List<CategoryVO>>

}