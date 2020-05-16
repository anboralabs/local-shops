package co.anbora.labs.localstores.domain.usecase.shops

import co.anbora.labs.localstores.domain.model.impl.LocalShopBo
import co.anbora.labs.localstores.domain.model.LocationBo
import co.anbora.labs.localstores.domain.repository.IRepository
import co.anbora.labs.localstores.domain.usecase.SuspendUseCase
import kotlinx.coroutines.CoroutineDispatcher

class GetAllNearLocalShops(
    private val repository: IRepository,
    defaultDispatcher: CoroutineDispatcher
): SuspendUseCase<GetAllNearLocalParameter, List<LocalShopBo>>(defaultDispatcher) {
    override suspend fun execute(parameters: GetAllNearLocalParameter): List<LocalShopBo>
            = repository.getAllNearestShops(LocationBo(parameters.latitude, parameters.longitude))
}

data class GetAllNearLocalParameter(val latitude: Float, val longitude: Float)