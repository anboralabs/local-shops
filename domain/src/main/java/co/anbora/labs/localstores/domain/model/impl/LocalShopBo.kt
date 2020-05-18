package co.anbora.labs.localstores.domain.model.impl

import co.anbora.labs.localstores.domain.model.ILocalShop
import co.anbora.labs.localstores.domain.model.ISchedule

data class LocalShopBo(
    private val id: String = "",
    private val name: String = "",
    private val description: String = "",
    private val category: String = "",
    private val address: String = "",
    private val phone: String = "",
    private val schedule: ISchedule = ScheduleBO(),
    private val latitude: Float = 0f,
    private val longitude: Float = 0f,
    private val images: List<String> = arrayListOf()
): ILocalShop {
    override fun id(): String = id

    override fun name(): String = name

    override fun description(): String = description

    override fun category(): String = category

    override fun address(): String = address

    override fun phone(): String = phone

    override fun schedule(): ISchedule = schedule

    override fun latitude(): Float = latitude

    override fun longitude(): Float = longitude

    override fun images(): List<String> = images
}