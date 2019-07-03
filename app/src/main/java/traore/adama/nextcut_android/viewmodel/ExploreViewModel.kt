package traore.adama.nextcut_android.viewmodel

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import traore.adama.nextcut_android.R
import traore.adama.nextcut_android.services.network.MyWebApi
import javax.inject.Inject

class ExploreViewModel(application: Application) : BaseViewModel(application){

    val Tag: String = ExploreViewModel::class.java.simpleName;

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
                { onRetrieveHaircutListSuccess() },
                {error -> onRetrieveHaircutListError(error.localizedMessage) }
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

    private fun onRetrieveHaircutListError(error: String){
        errorMessage.value =    R.string.haircuts_fetch_error

        Log.d(Tag, error)
    }


    override fun onCleared() {
        super.onCleared()
        if(!subscription.isDisposed)
            subscription.dispose()
    }

    fun getLoadingVisibility() : LiveData<Int> {
        return loadingVisibility
    }

}