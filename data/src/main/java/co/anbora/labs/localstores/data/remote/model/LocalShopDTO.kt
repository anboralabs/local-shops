package co.anbora.labs.localstores.data.remote.model

data class LocalShopDTO(
    val shopId: String = "",
    val localShopName: String = "",
    val localShopResume: String = "",
    val localShopCategory: String = "",
    val localShopAddress: String = "",
    val localShopPhone: String = "",
    val localShopSchedule: ScheduleDTO = ScheduleDTO(),
    val localShopLatitude: Float = 0f,
    val localShopLongitude: Float = 0f,
    val localShopImages: List<String> = arrayListOf()
)