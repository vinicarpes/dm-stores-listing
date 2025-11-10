package br.com.deliverymuch.storelisting.di

import br.com.deliverymuch.storelisting.retrofit.provideOkHttpClient
import br.com.deliverymuch.storelisting.retrofit.provideRetrofit
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
internal object HiltCompanyModule {
    @Provides
    fun provideRetrofit(): Retrofit {
        val okHttpClient = provideOkHttpClient(true)
        return provideRetrofit(okHttpClient)
    }
}