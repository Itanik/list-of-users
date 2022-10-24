package me.itanik.listofusers.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import me.itanik.listofusers.di.modules.NetworkModule
import me.itanik.listofusers.di.modules.PersistenceModule
import me.itanik.listofusers.di.modules.RepositoryModule
import me.itanik.listofusers.di.utils.ViewModelProviderFactory
import me.itanik.listofusers.ui.user_details.UserDetailsViewModel
import me.itanik.listofusers.ui.user_list.UserListViewModel
import javax.inject.Singleton

@Component(
    modules = [
        NetworkModule::class,
        PersistenceModule::class,
        RepositoryModule::class
    ]
)
@Singleton
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance applicationContext: Context): AppComponent
    }

    val userListViewModelProviderFactory: ViewModelProviderFactory<UserListViewModel>
    val userDetailsViewModelProviderFactory: ViewModelProviderFactory<UserDetailsViewModel>
}