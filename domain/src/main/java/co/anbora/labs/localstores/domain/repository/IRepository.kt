package co.anbora.labs.localstores.domain.repository

import co.anbora.labs.localstores.domain.result.Result
import co.anbora.labs.localstores.domain.model.CategoryBo
import co.anbora.labs.localstores.domain.model.LocalShopBo

interface IRepository {

    fun getCategories(): Result<List<CategoryBo>>

    fun getLocalShopsByCategory(categoryId: String): Result<List<LocalShopBo>>

}