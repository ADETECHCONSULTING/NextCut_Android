package traore.adama.nextcut_android.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import traore.adama.nextcut_android.database.NextCutDatabase
import traore.adama.nextcut_android.database.model.Nextcuter

public class FavoriteViewModel(application: Application) : AndroidViewModel(application) {
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