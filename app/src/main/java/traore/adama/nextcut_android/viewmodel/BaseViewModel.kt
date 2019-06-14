package traore.adama.nextcut_android.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import traore.adama.nextcut_android.dagger.components.DaggerViewModelComponent
import traore.adama.nextcut_android.dagger.modules.NetworkModule
import traore.adama.nextcut_android.dagger.components.ViewModelComponent

abstract class  BaseViewModel : ViewModel() {

    private val viewModelComponent: ViewModelComponent = DaggerViewModelComponent
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject(){
        when(this){
            is ExploreViewModel -> {
                viewModelComponent.inject(this)
            }
        }
    }
}

