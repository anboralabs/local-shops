package co.anbora.labs.localstores.ui.stores

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import co.anbora.labs.localstores.domain.model.ICategory
import co.anbora.labs.localstores.domain.model.ILocalShop
import co.anbora.labs.localstores.domain.result.Result
import co.anbora.labs.localstores.domain.usecase.shops.GetAllLocalShopsByCategoryUseCase
import co.anbora.labs.localstores.domain.usecase.shops.GetLocalShopsByCategoryParameters

class StoresViewModel(
    private val getLocalShopsByCategory: GetAllLocalShopsByCategoryUseCase
): ViewModel() {

    private var localShops: LiveData<Result<List<ILocalShop>>> = MutableLiveData()

    fun searchByCategory(category: ICategory) {
        localShops = getLocalShopsByCategory(GetLocalShopsByCategoryParameters(categoryId = category.id()))
            .asLiveData()
    }

    fun getLocalShops(): LiveData<Result<List<ILocalShop>>> {
        return localShops
    }
}
