package co.anbora.labs.localstores.data.local.mapper

import androidx.arch.core.util.Function
import co.anbora.labs.localstores.data.local.model.CategoryVO
import co.anbora.labs.localstores.domain.model.impl.CategoryBo

class CategoryMapper: Function<CategoryVO, CategoryBo> {
    override fun apply(input: CategoryVO): CategoryBo {
        return CategoryBo(
            id = input.id,
            name = input.name,
            description = input.description,
            imageUrl = input.getImage()
        )
    }
}