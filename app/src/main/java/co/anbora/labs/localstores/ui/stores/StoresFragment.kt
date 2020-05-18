package co.anbora.labs.localstores.ui.stores

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import co.anbora.labs.localstores.R
import co.anbora.labs.localstores.internal.util.lazyThreadSafetyNone
import co.anbora.labs.localstores.ui.category.CategoriesViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class StoresFragment : DaggerFragment() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel by lazyThreadSafetyNone {
        activity.let {
            ViewModelProvider(it!!, viewModelFactory).get(StoresViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.stores_fragment, container, false)
    }
}
