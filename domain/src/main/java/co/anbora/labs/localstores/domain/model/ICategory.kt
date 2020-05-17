package co.anbora.labs.localstores.domain.model

import java.io.Serializable

interface ICategory: Serializable {

    fun id(): String

    fun name(): String

    fun description(): String

    fun image(): String

}