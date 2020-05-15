package co.anbora.labs.localstores.data.local.mapper

import androidx.arch.core.util.Function
import co.anbora.labs.localstores.data.local.model.CategoryVO
import co.anbora.labs.localstores.domain.model.CategoryBo

class ListCategoryMapper(
    private val categoryMapper: Function<CategoryVO, CategoryBo>
): Function<List<CategoryVO>, List<CategoryBo>> {
    override fun apply(input: List<CategoryVO>): List<CategoryBo> {
        return input.map { categoryMapper.apply(it) }
    }
}