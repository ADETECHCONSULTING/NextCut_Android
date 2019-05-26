package traore.adama.nextcut_android.viewmodel

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import traore.adama.nextcut_android.database.NextCutDatabase
import traore.adama.nextcut_android.database.model.Nextcuter

class FavoriteViewModel(application: Application) : BaseViewModelContext(application) {
    private var favoritesList: LiveData<List<Nextcuter>>

    init {
        favoritesList = NextCutDatabase.getInstance(application.applicationContext)?.nextcuterDao()?.getAllFavorites()!!
    }


    fun getFavorites(): LiveData<List<Nextcuter>> {
        val data = MutableLiveData<List<Nextcuter>>()

        data.value = favoritesList.value
        return data
    }
}