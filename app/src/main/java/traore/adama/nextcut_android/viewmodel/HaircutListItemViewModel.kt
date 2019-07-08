package traore.adama.nextcut_android.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.MutableLiveData
import traore.adama.nextcut_android.database.model.Haircut


class HaircutListItemViewModel(application: Application) : BaseViewModel(application) {

    private val urlImage = MutableLiveData<String>()
    private val haircutName = MutableLiveData<String>()
    val context: Context = application.applicationContext

    fun bind(item: Haircut) {
        urlImage.value = item.urlImage
        haircutName.value = item.haircutName
    }

    fun getName(): MutableLiveData<String> {
        return haircutName
    }

    fun getUrlImage(): MutableLiveData<String> {
        return urlImage
    }

}