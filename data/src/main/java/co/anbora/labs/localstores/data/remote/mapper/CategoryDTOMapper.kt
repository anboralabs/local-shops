package co.anbora.labs.localstores.data.remote.mapper

import androidx.arch.core.util.Function
import co.anbora.labs.localstores.data.local.model.CategoryVO
import co.anbora.labs.localstores.data.remote.model.CategoryDTO

class CategoryDTOMapper: Function<CategoryDTO, CategoryVO> {
    override fun apply(input: CategoryDTO): CategoryVO {
        return CategoryVO(
            id = input.categoryId,
            name = input.categoryName,
            description = input.categoryDescription,
            urlRemoteImage = input.imageCategory
        )
    }
}