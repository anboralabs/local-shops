package co.anbora.labs.localstores.ui.stores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import co.anbora.labs.localstores.databinding.StoresFragmentBinding
import co.anbora.labs.localstores.internal.util.lazyThreadSafetyNone
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class StoresFragment : DaggerFragment() {

    @Inject
    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    private val args: StoresFragmentArgs  by navArgs()

    private lateinit var binding: StoresFragmentBinding
    private val viewModel by lazyThreadSafetyNone {
        activity.let {
            ViewModelProvider(it!!, viewModelFactory).get(StoresViewModel::class.java)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        setupUI(inflater, container)
        setupUX()
        return binding.root
    }

    private fun setupUI(inflater: LayoutInflater, container: ViewGroup?) {
        binding = StoresFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }

    private fun setupUX() {
        args.category?.let {
            viewModel.searchByCategory(it)
        }
    }
}
