package traore.adama.nextcut_android.viewmodel

import android.app.Application
import android.arch.lifecycle.LiveData
import traore.adama.nextcut_android.database.model.Nextcuter
import traore.adama.nextcut_android.service.repository.NextcuterRepository

class HomeViewModel(application: Application) : BaseViewModelContext(application) {
    private var nextcuterList: LiveData<List<Nextcuter>>

    init {
        nextcuterList = NextcuterRepository.instance.getNextcuters()
    }


    fun getNextcuters():LiveData<List<Nextcuter>>{
        return nextcuterList
    }
}