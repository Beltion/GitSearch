package ru.gitsearch.feature

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.NavDirections
import androidx.navigation.findNavController
import ru.gitsearch.domain.entities.GlobalError
import ru.gitsearch.feature.main.MainVM

abstract class Screen : Fragment() {

    private val activityVM by activityViewModels<MainVM>()
    val onGlobalErrorCloseAction get() = activityVM.globalErrorCloseEvent
    val globalIsLoad get() = activityVM.isLoad

    fun setGlobalError(globalError: GlobalError?) {
        activityVM.globalErrorDesc.value = globalError?.desc
    }

    fun navigate(direction: NavDirections) {
        requireView().findNavController().navigate(direction)
    }
}