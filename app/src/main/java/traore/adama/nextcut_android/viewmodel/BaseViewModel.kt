package traore.adama.nextcut_android.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {

}

open class BaseViewModelContext(application: Application): AndroidViewModel(application){

}