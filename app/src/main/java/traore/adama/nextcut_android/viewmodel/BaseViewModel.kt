package traore.adama.nextcut_android.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import traore.adama.nextcut_android.dagger.components.DaggerViewModelComponent
import traore.adama.nextcut_android.dagger.components.ViewModelComponent
import traore.adama.nextcut_android.dagger.modules.NetworkModule

abstract class  BaseViewModel(application: Application) : AndroidViewModel(application) {

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

