package co.anbora.labs.localstores.domain.usecase.categories

import co.anbora.labs.localstores.domain.model.impl.CategoryBo
import co.anbora.labs.localstores.domain.repository.IRepository
import co.anbora.labs.localstores.domain.result.Result
import co.anbora.labs.localstores.domain.usecase.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetAllCategoriesUseCase(
    private val repository: IRepository,
    defaultDispatcher: CoroutineDispatcher
): FlowUseCase<Unit, List<CategoryBo>>(defaultDispatcher) {

    override fun execute(parameters: Unit): Flow<Result<List<CategoryBo>>> = repository.getCategories()
}