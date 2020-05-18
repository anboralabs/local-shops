package co.anbora.labs.localstores.domain.model.impl

import co.anbora.labs.localstores.domain.model.ISchedule

data class ScheduleBO(
    private val startTime: String = "",
    private val endTime: String = ""
): ISchedule {
    override fun startTime(): String = startTime

    override fun endTime(): String = endTime

    override fun hasSchedule(): Boolean {
        return startTime().isNotBlank() && endTime().isNotBlank()
    }
}