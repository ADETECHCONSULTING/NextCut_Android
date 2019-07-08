package traore.adama.nextcut_android.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import traore.adama.nextcut_android.database.model.Haircut
import traore.adama.nextcut_android.database.model.Nextcuter
import traore.adama.nextcut_android.repository.HaircutRepository
import traore.adama.nextcut_android.repository.NextcuterRepository

class HomeViewModel(application: Application) : AndroidViewModel(application) {
    private var nextcuterList: LiveData<List<Nextcuter>>
    private var haircutList : LiveData<List<Haircut>>

    init {
        haircutList = HaircutRepository.instance.getHaircuts()
        nextcuterList = NextcuterRepository.instance.getNextcuters()
    }


    fun getNextcuters():LiveData<List<Nextcuter>>{
        return nextcuterList
    }

    fun getHaircuts():LiveData<List<Haircut>>{
        return haircutList
    }


}