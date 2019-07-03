package traore.adama.nextcut_android.viewmodel

import android.app.Application
import android.content.Context
import android.graphics.Color
import androidx.lifecycle.MutableLiveData
import traore.adama.nextcut_android.database.NextCutDatabase
import traore.adama.nextcut_android.database.model.Nextcuter


class NextcuterListItemViewModel(application: Application) : BaseViewModel(application) {
    private val prices = MutableLiveData<String>()
    private val urlImage = MutableLiveData<String>()
    private val nextcutersName = MutableLiveData<String>()
    private val background = MutableLiveData<Int>()
    val isFavorite = MutableLiveData<Boolean>()
    val context: Context = application.applicationContext


    fun bind(item: Nextcuter)
    {
        prices.value = displayPrices(getPrices(item.id))
        nextcutersName.value = "${item.firstname} ${item.lastname}"
        background.value = randomColor()
    }

    fun getPrices(nextcuterId: Long?) : List<Int>? {
        if (nextcuterId == null) emptyList<Int>()

        val prestations =
            NextCutDatabase.getInstance(context)?.prestationDao()?.getPrestationsByNextcuter(nextcuterId!!)
                ?: return emptyList() //if DAO don't found list of prestation Returns an empty read-only list

        return prestations.value?.map { prestation ->
            prestation.price ?: 0
        }
    }

    fun displayPrices(prices: List<Int>?): String{

        return if (prices != null) "${prices.min()} - ${prices.max()}" else "no prices"
    }


    fun randomColor():Int{

        val r = (0xff * Math.random()).toInt()
        val g = (0xff * Math.random()).toInt()
        val b = (0xff * Math.random()).toInt()

        return Color.rgb(r, g, b)
    }

    fun getBackground() : MutableLiveData<Int>{
        return background
    }

    fun getName() : MutableLiveData<String>{
        return nextcutersName
    }

    fun getPrices() : MutableLiveData<String>{
        return prices
    }
}