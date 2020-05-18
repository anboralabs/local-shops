package co.anbora.labs.localstores.data.remote.model

data class ScheduleDTO(
    private val startTime: String = "",
    private val endTime: String = ""
) {

    fun hasSchedule(): Boolean {
        return startTime.isNotEmpty() && endTime.isNotEmpty()
    }

}