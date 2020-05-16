package co.anbora.labs.localstores.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ListBindingAdapter<T>(
    protected var items: MutableList<T>
): RecyclerView.Adapter<ListBindingAdapter.ViewHolder<T>>() {

    interface Callbacks<T> {
        fun onItemClick(view: View, item: T)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder<T>, position: Int) = holder.bind(items[position])

    fun update(items: List<T>) {
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    abstract class ViewHolder<T>(view: View) : RecyclerView.ViewHolder(view) {

        abstract fun bind(item: T)
    }
}