package ru.gitsearch.utils.extention

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun<T> LiveData<T>.nullSafeObserve(owner: LifecycleOwner, observer: (t: T) -> Unit){
    this.observe(owner) {
        it?.let(observer)
    }
}