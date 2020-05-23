package co.anbora.labs.localstores.domain.model

interface ILocalShop {

    fun id(): String

    fun name(): String

    fun description(): String

    fun category(): String

    fun address(): String

    fun phone(): String

    fun schedule(): ISchedule

    fun latitude(): Float

    fun longitude(): Float

    fun image(): String {
        return if (images().isNotEmpty()) {
            images().first()
        } else {
            ""
        }
    }

    fun images(): List<String>

}