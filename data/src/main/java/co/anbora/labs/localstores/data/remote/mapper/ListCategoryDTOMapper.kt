package co.anbora.labs.localstores.data.remote.mapper

import androidx.arch.core.util.Function
import co.anbora.labs.localstores.data.local.model.CategoryVO
import co.anbora.labs.localstores.data.remote.model.CategoryDTO

class ListCategoryDTOMapper(
    private val mapper: Function<CategoryDTO, CategoryVO>
): Function<List<CategoryDTO>, List<CategoryVO>> {
    override fun apply(input: List<CategoryDTO>): List<CategoryVO> {
        return input.map {
            mapper.apply(it)
        }
    }
}