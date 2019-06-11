package traore.adama.nextcut_android.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {

}

abstract class BaseViewModelContext(application: Application): AndroidViewModel(application){

}