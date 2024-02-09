package com.rizfan.tourismapp.di

import com.rizfan.tourismapp.core.di.CoreComponent
import com.rizfan.tourismapp.detail.DetailTourismActivity
import com.rizfan.tourismapp.favorite.FavoriteFragment
import com.rizfan.tourismapp.home.HomeFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [CoreComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AppComponent
    }

    fun inject(fragment: HomeFragment)
    fun inject(fragment: FavoriteFragment)
    fun inject(activity: DetailTourismActivity)
}