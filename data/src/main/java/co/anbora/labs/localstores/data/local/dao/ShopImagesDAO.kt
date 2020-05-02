package co.anbora.labs.localstores.data.local.dao

import androidx.room.*
import co.anbora.labs.localstores.data.local.model.LocalShopVO
import co.anbora.labs.localstores.data.local.model.ShopImagesVO

@Dao
interface ShopImagesDAO {

    /**
     * Inserts [images] into the [ShopImagesVO.TABLE_NAME] table.
     * Duplicate values are replaced in the table.
     * @param images ShopImagesVO
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(images: List<ShopImagesVO>)

    /**
     * Fetches all the images from the [ShopImagesVO.TABLE_NAME] table by local shop.
     * @param localShopId String, local shop identifier
     * @return [List]
     */
    @Query("SELECT * FROM ${ShopImagesVO.TABLE_NAME} WHERE ${ShopImagesVO.COLUMN_LOCAL_SHOP_ID} = :localShopId")
    fun getAllBy(localShopId: String): List<ShopImagesVO>

    @Transaction
    fun updateImages(localShopVO: LocalShopVO) {
        localShopVO.remoteId?.run {
            val images = getAllBy(localShopId = localShopVO.internalId)
            val updatedWithRemoteId = images.map {
                it.copy(localShopId = localShopVO.remoteId)
            }
            insert(updatedWithRemoteId)
        }
    }
}