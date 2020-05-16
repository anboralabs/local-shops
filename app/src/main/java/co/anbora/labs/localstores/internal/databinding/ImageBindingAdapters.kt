package co.anbora.labs.localstores.internal.databinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import co.anbora.labs.localstores.R
import com.squareup.picasso.Picasso


object ImageBindingAdapters {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, imageUrl: String?) {
        Picasso.get()
            .load(imageUrl)
            .placeholder(R.drawable.ic_not_found)
            .into(view)
    }
}