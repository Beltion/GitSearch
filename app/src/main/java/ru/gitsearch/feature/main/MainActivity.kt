package ru.gitsearch.feature.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ru.gitsearch.R
import ru.gitsearch.databinding.ActivityMainBinding
import ru.gitsearch.utils.extention.invisibleIf
import ru.gitsearch.utils.extention.nullSafeObserve
import ru.gitsearch.utils.extention.visibleIf

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val activityVM by viewModels<MainVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.apply {
            lifecycleOwner = this@MainActivity
            vm = activityVM
        }

        initObservers()
    }

    private fun initObservers() {
        activityVM.apply {
            isLoad.nullSafeObserve(this@MainActivity){
                binding.loadingLayout.root.visibleIf(it)
            }
            globalErrorDesc.observe(this@MainActivity) {
                binding.errorLayout.root.invisibleIf(it.isNullOrEmpty())
            }
            globalErrorCloseEvent.observe(this@MainActivity) {
                globalErrorDesc.value = null
            }
        }
    }

}

