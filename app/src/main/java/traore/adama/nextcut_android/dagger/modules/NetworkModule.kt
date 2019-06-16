package traore.adama.nextcut_android.dagger.modules

import dagger.Module
import dagger.Provides
import dagger.Reusable
import io.reactivex.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import traore.adama.nextcut_android.services.network.MyWebApi
import traore.adama.nextcut_android.utils.Constants
import okhttp3.logging.HttpLoggingInterceptor



/**
 * Module will provide all the required dependencies
 */
@Module
object NetworkModule{

    /**
     * Provides MyWebApi service for dagger uses
     */
    @Provides
    @Reusable //https://stackoverflow.com/a/39154297/8526518
    @JvmStatic //https://stackoverflow.com/a/48781460/8526518
    internal fun provideMyWebApi(retrofit: Retrofit): MyWebApi{
        return retrofit.create(MyWebApi::class.java)
    }

    /**
     * Provides the logging for retrofit
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideLoggingInterceptor() : OkHttpClient {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder().addInterceptor(interceptor).build()
    }

    /**
     * Provides the retrofit object for dagger uses
     * Why RxJava2CallAdapterFactory ?
     * A call adapter which uses RxJava 2 for creating observables.
     * Adding this class to Retrofit allows you to return an Observable, Flowable, Single, Completable or Maybe from service methods.
     */
    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(client: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .build()
    }
}