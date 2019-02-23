package com.wipro.assignment.rest.di

import com.wipro.assignment.rest.core.RestClient
import dagger.Component
import javax.inject.Singleton

/**
 * Created by krishnas on 2/22/2019.
 */
@Singleton
@Component(modules = [RestModule::class])
public interface RestComponent {
    /*@Component.Builder
    interface Builder {
        @BindsInstance
        fun restModule(restModule: RestModule): Builder

        fun build(): RestComponent
    }*/

    fun inject(client: RestClient)
}