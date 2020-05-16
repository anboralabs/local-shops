package co.anbora.labs.localstores.data.local

import co.anbora.labs.localstores.data.remote.model.CategoryDTO
import co.anbora.labs.localstores.domain.model.impl.CategoryBo
import kotlinx.coroutines.flow.Flow

interface ICategoryManager {

    fun getCategories(): Flow<List<CategoryBo>>

    fun saveCategories(response: List<CategoryDTO>)

}