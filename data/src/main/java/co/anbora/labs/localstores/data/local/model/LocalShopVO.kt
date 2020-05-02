package co.anbora.labs.localstores.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import co.anbora.labs.localstores.data.local.model.LocalShopVO.Companion.COLUMN_REMOTE_ID
import co.anbora.labs.localstores.data.local.model.LocalShopVO.Companion.TABLE_NAME
import java.util.*

@Entity(tableName = TABLE_NAME, indices = [Index(value = [COLUMN_REMOTE_ID], unique = true)])
data class LocalShopVO(
    @PrimaryKey
    @ColumnInfo(
        index = true,
        name = COLUMN_INTERNAL_ID
    )
    val internalId: String = UUID.randomUUID().toString(),
    @ColumnInfo(name = COLUMN_REMOTE_ID)
    val remoteId: String? = null,
    @ColumnInfo(name = COLUMN_NAME)
    val name: String,
    @ColumnInfo(name = COLUMN_OVERVIEW)
    val overview: String,
    @ColumnInfo(name = COLUMN_CATEGORY_ID)
    val categoryId: String,
    @ColumnInfo(name = COLUMN_ADDRESS)
    val address: String,
    @ColumnInfo(name = COLUMN_PHONE)
    val phone: String,
    @ColumnInfo(name = COLUMN_LATITUDE)
    val latitude: Float,
    @ColumnInfo(name = COLUMN_LONGITUDE)
    val longitude: Float
) {

    fun isSync(): Boolean = remoteId != null

    companion object {
        const val TABLE_NAME = "local_shops"

        const val COLUMN_INTERNAL_ID = "shop_internal_id"
        const val COLUMN_REMOTE_ID = "shop_remote_id"
        const val COLUMN_NAME = "shop_name"
        const val COLUMN_OVERVIEW = "shop_overview"
        const val COLUMN_CATEGORY_ID = "shop_category_id"
        const val COLUMN_ADDRESS = "shop_address"
        const val COLUMN_PHONE = "shop_phone"
        const val COLUMN_LATITUDE = "shop_latitude"
        const val COLUMN_LONGITUDE = "shop_longitude"
    }
}