package traore.adama.nextcut_android.services.network

import io.reactivex.Observable
import retrofit2.http.GET
import traore.adama.nextcut_android.database.model.Haircut

interface MyWebApi{


    @GET("/demo")
    fun getHaircuts() : Observable<List<Haircut>>
}