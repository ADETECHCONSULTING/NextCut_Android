package traore.adama.nextcut_android.viewmodel

import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.services.network.MyWebApi
import javax.inject.Inject

class ExploreViewModel:BaseViewModel(){

    @Inject
    lateinit var myWebApi: MyWebApi

    private lateinit var subscription: Disposable
    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadHaircuts() }

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
        errorMessage.value = R.string.haircuts_fetch_error
    }


    override fun onCleared() {
        super.onCleared()
        if(!subscription.isDisposed)
            subscription.dispose()
    }


}