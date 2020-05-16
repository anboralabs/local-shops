package co.anbora.labs.localstores.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import co.anbora.labs.localstores.adapters.ListBindingAdapter
import co.anbora.labs.localstores.databinding.CategoriesFragmentBinding
import co.anbora.labs.localstores.domain.model.ICategory
import co.anbora.labs.localstores.internal.util.lazyThreadSafetyNone
import javax.inject.Inject

class CategoriesFragment : Fragment(), ListBindingAdapter.Callbacks<ICategory> {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var binding: CategoriesFragmentBinding
    private val viewModel by lazyThreadSafetyNone {
        activity.let {
            ViewModelProvider(it!!, viewModelFactory).get(CategoriesViewModel::class.java)
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setupUI(inflater, container)
        return binding.root
    }

    private fun setupUI(inflater: LayoutInflater, container: ViewGroup?) {
        binding = CategoriesFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.callback = this
    }

    override fun onItemClick(view: View, item: ICategory) {

    }

}
