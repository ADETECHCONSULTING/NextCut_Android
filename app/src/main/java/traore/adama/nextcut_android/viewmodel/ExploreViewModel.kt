package traore.adama.nextcut_android.viewmodel

import android.view.View
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import traore.adama.nextcut_android.services.network.MyWebApi
import javax.inject.Inject

class ExploreViewModel:BaseViewModel(){

    @Inject
    lateinit var myWebApi: MyWebApi

    private lateinit var subscription: Disposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init {
        loadHaircuts()
    }

    private fun loadHaircuts(){
        subscription = myWebApi.getHaircuts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { onRetrieveHaircutListStart() }
            .doOnTerminate { onRetrieveHaircutListFinish() }
            .subscribe(
                {onRetrieveHaircutListSuccess()},
                {onRetrieveHaircutListError()}
            )
    }


    private fun onRetrieveHaircutListStart(){
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrieveHaircutListFinish(){
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveHaircutListSuccess(){

    }

    private fun onRetrieveHaircutListError(){

    }


    override fun onCleared() {
        super.onCleared()
        if(!subscription.isDisposed)
            subscription.dispose()
    }
}