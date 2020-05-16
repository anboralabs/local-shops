package co.anbora.labs.localstores.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import co.anbora.labs.localstores.domain.model.ICategory
import co.anbora.labs.localstores.domain.result.Result
import co.anbora.labs.localstores.domain.usecase.categories.GetAllCategoriesUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn

class CategoriesViewModel(
    private val getAllCategoriesUseCase: GetAllCategoriesUseCase
): ViewModel() {

    private var categories: LiveData<Result<List<ICategory>>> = getAllCategoriesUseCase(Unit)
        .flowOn(Dispatchers.IO)
        .asLiveData()

    fun getCategories() : LiveData<Result<List<ICategory>>> {
        return categories
    }
}
