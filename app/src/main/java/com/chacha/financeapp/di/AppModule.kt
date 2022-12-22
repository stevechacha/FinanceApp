package com.chacha.financeapp.di

import android.app.Application
import androidx.room.Room
import com.chacha.financeapp.core.data.local.FinanceDatabase
import com.chacha.financeapp.feature_auth.data.repository.AuthRepositoryImpl
import com.chacha.financeapp.feature_auth.domain.repository.AuthRepository
import com.chacha.financeapp.core.util.Constants.DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideAuthRepository(
        repositoryImpl: AuthRepositoryImpl
    ): AuthRepository = repositoryImpl


    @Provides
    @Singleton
    fun provideFinanceDatabase(application: Application): FinanceDatabase {
        return  Room.databaseBuilder(
            application.applicationContext,
            FinanceDatabase::class.java,
            DATABASE_NAME
        ).build()
    }



}