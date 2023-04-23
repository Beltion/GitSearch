package ru.gitsearch.feature

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ru.gitsearch.domain.entities.GlobalError

abstract class BaseVM : ViewModel() {
    val isLoad = MutableLiveData(false)
    val globalError = MutableLiveData<GlobalError?>()
}