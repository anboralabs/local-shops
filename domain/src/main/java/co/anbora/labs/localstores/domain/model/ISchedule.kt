package co.anbora.labs.localstores.domain.model

interface ISchedule {

    fun startTime(): String

    fun endTime(): String

    fun hasSchedule(): Boolean

}