package traore.adama.nextcut_android.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import traore.adama.nextcut_android.dagger.DaggerViewModelComponent
import traore.adama.nextcut_android.dagger.NetworkModule

abstract class BaseViewModel : ViewModel() {

    private val viewModelComponent = DaggerViewModelComponent
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
            is ExploreViewModel -> viewModelComponent
        }
    }
}

abstract class BaseViewModelContext(application: Application): AndroidViewModel(application){

}