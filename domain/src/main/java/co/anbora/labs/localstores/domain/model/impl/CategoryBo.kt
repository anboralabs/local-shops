package co.anbora.labs.localstores.domain.model.impl

import co.anbora.labs.localstores.domain.model.ICategory

data class CategoryBo(
    private val id: String,
    private val name: String,
    private val description: String,
    private val imageUrl: String
): ICategory {
    override fun id(): String = id

    override fun name(): String = name

    override fun description(): String = description

    override fun image(): String = imageUrl
}