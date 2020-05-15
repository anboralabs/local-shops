package co.anbora.labs.localstores.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import co.anbora.labs.localstores.data.local.model.CategoryVO.Companion.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class CategoryVO (
    @PrimaryKey
    @ColumnInfo(
        index = true,
        name = COLUMN_REMOTE_ID
    )
    val id: String,
    @ColumnInfo(name = COLUMN_NAME)
    val name: String,
    @ColumnInfo(name = COLUMN_DESCRIPTION)
    val description: String,
    @ColumnInfo(name = COLUMN_REMOTE_IMAGE)
    val urlRemoteImage: String,
    @ColumnInfo(name = COLUMN_LOCAL_IMAGE, defaultValue = "")
    val urlLocalImageSync: String = ""
) {

    companion object {
        const val TABLE_NAME = "categories"

        const val COLUMN_REMOTE_ID = "category_remote_id"
        const val COLUMN_NAME = "category_name"
        const val COLUMN_DESCRIPTION = "category_description"
        const val COLUMN_REMOTE_IMAGE = "category_remote_image"
        const val COLUMN_LOCAL_IMAGE = "category_local_image"
    }

    fun getImage(): String {
        return if (urlLocalImageSync.isNotEmpty()) {
            urlLocalImageSync
        } else {
            urlRemoteImage
        }
    }
}