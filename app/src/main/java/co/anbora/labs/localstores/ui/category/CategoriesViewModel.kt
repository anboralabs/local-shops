package co.anbora.labs.localstores.ui.category

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import co.anbora.labs.localstores.domain.model.ICategory

class CategoriesViewModel : ViewModel() {

    private val categories: MutableLiveData<Result<List<ICategory>>> = MutableLiveData()



    fun getCategories() : LiveData<Result<List<ICategory>>> {
        return categories
    }
}
