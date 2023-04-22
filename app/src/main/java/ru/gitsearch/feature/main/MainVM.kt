package ru.gitsearch.feature.main

import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor() {

    val globalErrorDesc = MutableLiveData<String>(null)
    val globalErrorCloseEvent = MutableLiveData<Boolean>()

    fun onErrorBtnTap() {
        globalErrorCloseEvent.value = true
    }

}