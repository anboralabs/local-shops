package co.anbora.labs.localstores.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import co.anbora.labs.localstores.data.local.model.ShopImagesVO.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class ShopImagesVO(
    @PrimaryKey
    @ColumnInfo(
        index = true,
        name = COLUMN_INTERNAL_ID
    )
    val internalId: String,
    @ColumnInfo(name = COLUMN_LOCAL_SHOP_ID)
    val localShopId: String,
    @ColumnInfo(name = COLUMN_IMAGE_URI)
    val imageUri: String,
    @ColumnInfo(name = COLUMN_SYNC)
    val sync: Boolean
) {

    companion object {
        const val TABLE_NAME = "images"

        const val COLUMN_INTERNAL_ID = "image_internal_id"
        const val COLUMN_LOCAL_SHOP_ID = "image_local_shop_id"
        const val COLUMN_IMAGE_URI = "image_uri"
        const val COLUMN_SYNC = "image_sync"
    }

}