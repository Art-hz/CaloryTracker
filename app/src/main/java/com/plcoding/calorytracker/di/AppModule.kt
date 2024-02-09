package com.plcoding.calorytracker.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.plcoding.core.data.preferences.DefaultPreferences
import com.plcoding.core.domain.preferences.Preferences
import com.plcoding.core.domain.use_case.FilterOutDigits
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    //es donde se definen las dependencias de los modulos, clases que necesitamos en la app en general
    @Provides
    @Singleton
    fun provideSharedPreferences(app: Application): SharedPreferences {
        return app.getSharedPreferences("shared_pref", MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences {
        return DefaultPreferences(sharedPref = sharedPreferences)
    }

    @Provides
    @Singleton
    fun provideFilterDigitsUseCase(): FilterOutDigits {
        return FilterOutDigits()
    }
}