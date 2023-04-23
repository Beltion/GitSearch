package ru.gitsearch.feature.file

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.gitsearch.databinding.FragmentFileBinding
import ru.gitsearch.feature.Screen
import ru.gitsearch.utils.extention.nullSafeObserve

@AndroidEntryPoint
class FileFragment : Screen() {

    private lateinit var binding: FragmentFileBinding
    private val viewModel: FileVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFileBinding.inflate(
            inflater,
            container,
            false
        ).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
        }

        initObservers()

        return binding.root
    }

    private fun initObservers() {
        viewModel.apply {
            globalError.observe(viewLifecycleOwner) {setGlobalError(it)}
            isLoad.nullSafeObserve(viewLifecycleOwner) {
                this@FileFragment.globalIsLoad.value = it
            }
            onGlobalErrorCloseAction.observe(viewLifecycleOwner) {
                // TODO: add on btn click action
            }
        }
    }

}