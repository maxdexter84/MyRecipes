package ru.maxdexter.myrecipes.di.component

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import ru.maxdexter.myrecipes.di.ViewModelBuilderModule
import javax.inject.Singleton

@Singleton
@Component(modules = [ViewModelBuilderModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}