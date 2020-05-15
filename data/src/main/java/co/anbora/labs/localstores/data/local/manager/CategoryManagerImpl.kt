package co.anbora.labs.localstores.data.local.manager

import co.anbora.labs.localstores.data.local.ICategoryManager
import co.anbora.labs.localstores.data.remote.model.CategoryDTO
import co.anbora.labs.localstores.domain.model.CategoryBo
import kotlinx.coroutines.flow.Flow

class CategoryManagerImpl: ICategoryManager {
    override fun getCategories(): Flow<List<CategoryBo>> {
        TODO("Not yet implemented")
    }

    override fun saveCategories(response: List<CategoryDTO>) {
        TODO("Not yet implemented")
    }
}