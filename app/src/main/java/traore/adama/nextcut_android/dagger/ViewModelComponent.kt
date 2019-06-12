package traore.adama.nextcut_android.dagger

import dagger.Component
import traore.adama.nextcut_android.viewmodel.HaircutViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelComponent{

    /**
     * Injects required dependencies into the specified HaircutViewModel.
     * @param haircutViewModel HaircutViewModel in which to inject the dependencies
     */
    fun inject(haircutViewModel: HaircutViewModel)


    @Component.Builder
    interface Builder{

        fun build() : ViewModelComponent

        fun networkModule(networkModule: NetworkModule) : Builder
    }
}