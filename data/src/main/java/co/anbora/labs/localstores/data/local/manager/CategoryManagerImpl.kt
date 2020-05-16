package co.anbora.labs.localstores.data.local.manager

import co.anbora.labs.localstores.data.local.ICategoryManager
import co.anbora.labs.localstores.data.local.dao.CategoryDAO
import co.anbora.labs.localstores.data.local.mapper.ListCategoryMapper
import co.anbora.labs.localstores.data.remote.mapper.ListCategoryDTOMapper
import co.anbora.labs.localstores.data.remote.model.CategoryDTO
import co.anbora.labs.localstores.domain.model.impl.CategoryBo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CategoryManagerImpl(
    private val categoriesDAO: CategoryDAO,
    private val listCategoryMapper: ListCategoryMapper,
    private val listCategoryDTOMapper: ListCategoryDTOMapper
): ICategoryManager {
    override fun getCategories(): Flow<List<CategoryBo>> {
        return categoriesDAO.getAll()
            .map { listCategoryMapper.apply(it) }
    }

    override fun saveCategories(response: List<CategoryDTO>) {
        categoriesDAO.insert(
            listCategoryDTOMapper.apply(response)
        )
    }
}