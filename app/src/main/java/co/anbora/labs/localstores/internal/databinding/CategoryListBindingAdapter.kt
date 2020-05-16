package co.anbora.labs.localstores.internal.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import co.anbora.labs.localstores.adapters.CategoryListAdapter
import co.anbora.labs.localstores.adapters.ListBindingAdapter
import co.anbora.labs.localstores.domain.model.ICategory
import co.anbora.labs.localstores.domain.result.Result

object CategoryListBindingAdapter {

    @JvmStatic
    @BindingAdapter("categories", "callback", requireAll = true)
    fun setCategoryAdapter(
        recyclerView: RecyclerView,
        items: Result<List<ICategory>>?,
        callbacks: ListBindingAdapter.Callbacks<ICategory>?
    ) {

        if (items != null) {
            when(items) {
                is Result.Success -> {
                    if (callbacks != null) {
                        recyclerView.setHasFixedSize(true)
                        if (recyclerView.adapter != null) {
                            val adapter = recyclerView.adapter as CategoryListAdapter
                            adapter.update(items.data)
                        } else {
                            recyclerView.adapter = CategoryListAdapter(items.data.toMutableList(), callbacks)
                        }
                    }
                }
            }
        }
    }

}