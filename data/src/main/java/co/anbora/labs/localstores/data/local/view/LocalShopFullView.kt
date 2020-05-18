package co.anbora.labs.localstores.data.local.view

import androidx.room.DatabaseView
import androidx.room.Embedded
import androidx.room.Relation
import androidx.room.SkipQueryVerification
import co.anbora.labs.localstores.data.local.model.CategoryVO
import co.anbora.labs.localstores.data.local.model.LocalShopVO
import co.anbora.labs.localstores.data.local.model.ShopImagesVO

@SkipQueryVerification
@DatabaseView(
    """
    SELECT ${LocalShopVO.TABLE_NAME}.*, 
    Transform(MakePoint(${LocalShopVO.TABLE_NAME}.shop_latitude, 
                ${LocalShopVO.TABLE_NAME}.shop_longitude, 4326), 26986) as geo_point 
    FROM ${LocalShopVO.TABLE_NAME}
    """)
data class LocalShopFullView(
    @Embedded
    val localShop: LocalShopVO,

    @Relation(
        parentColumn = LocalShopVO.COLUMN_CATEGORY_ID,
        entityColumn = CategoryVO.COLUMN_REMOTE_ID
    )
    val category: CategoryVO,

    @Relation(
        parentColumn = LocalShopVO.COLUMN_INTERNAL_ID,
        entity = ShopImagesVO::class,
        entityColumn = ShopImagesVO.COLUMN_LOCAL_SHOP_ID
    )
    val images: List<ShopImagesVO>
)