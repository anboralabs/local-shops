package co.anbora.labs.localstores.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import co.anbora.labs.localstores.databinding.ItemCategoryBinding
import co.anbora.labs.localstores.domain.model.ICategory

class CategoryListAdapter(
    items: MutableList<ICategory>,
    private val callbacks: Callbacks<ICategory>
): ListBindingAdapter<ICategory>(items) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder<ICategory> = CategoryViewHolder(parent)

    inner class CategoryViewHolder(
        private val parent: ViewGroup,
        private val binding: ItemCategoryBinding = ItemCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
    ): ListBindingAdapter.ViewHolder<ICategory>(binding.root) {

        init {
            itemView.setOnClickListener { callbacks.onItemClick(it, items[adapterPosition]) }
        }

        override fun bind(item: ICategory) {
            binding.category = item
            binding.executePendingBindings()
        }
    }
}