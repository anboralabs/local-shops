package co.anbora.labs.localstores.domain.usecase.shops

import co.anbora.labs.localstores.domain.model.impl.LocalShopBo
import co.anbora.labs.localstores.domain.repository.IRepository
import co.anbora.labs.localstores.domain.result.Result
import co.anbora.labs.localstores.domain.usecase.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

class GetAllLocalShopsByCategoryUseCase(
    private val repository: IRepository,
    defaultDispatcher: CoroutineDispatcher
): FlowUseCase<GetLocalShopsByCategoryParameters, List<LocalShopBo>>(defaultDispatcher) {

    override fun execute(parameters: GetLocalShopsByCategoryParameters): Flow<Result<List<LocalShopBo>>>
            = repository.getLocalShopsByCategory(parameters.categoryId)
}

data class GetLocalShopsByCategoryParameters(val categoryId: String)