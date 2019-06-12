package traore.adama.nextcut_android.dagger

import dagger.Component
import traore.adama.nextcut_android.viewmodel.ExploreViewModel
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface ViewModelComponent{

    /**
     * Injects required dependencies into the specified ExploreViewModel.
     * @param exploreViewModel ExploreViewModel in which to inject the dependencies
     */
    fun inject(exploreViewModel: ExploreViewModel)


    @Component.Builder
    interface Builder{

        fun build() : ViewModelComponent

        fun networkModule(networkModule: NetworkModule) : Builder
    }
}