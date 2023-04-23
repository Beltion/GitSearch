package ru.gitsearch.feature.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor() : ViewModel() {

    val globalErrorDesc = MutableLiveData<String>(null)
    val globalErrorCloseEvent = MutableLiveData<Boolean>()

    val isLoad = MutableLiveData(false)

    fun onErrorBtnTap() {
        globalErrorCloseEvent.value = true
    }

}