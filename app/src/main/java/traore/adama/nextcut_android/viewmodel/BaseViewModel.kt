package traore.adama.nextcut_android.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import traore.adama.nextcut_android.dagger.ViewModelComponent

abstract class BaseViewModel : ViewModel() {



}

abstract class BaseViewModelContext(application: Application): AndroidViewModel(application){

}