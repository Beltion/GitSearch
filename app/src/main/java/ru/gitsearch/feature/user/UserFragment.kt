package ru.gitsearch.feature.user

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.gitsearch.databinding.FragmentUserBinding
import ru.gitsearch.feature.Screen
import ru.gitsearch.utils.extention.nullSafeObserve

@AndroidEntryPoint
class UserFragment : Screen() {

    private lateinit var binding: FragmentUserBinding
    private val viewModel: UserVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentUserBinding.inflate(
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
                this@UserFragment.globalIsLoad.value = it
            }
            onGlobalErrorCloseAction.observe(viewLifecycleOwner) {
                // TODO: add on btn click action
            }
        }
    }

}