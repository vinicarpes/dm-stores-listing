package br.com.deliverymuch.storelisting.di

import br.com.deliverymuch.storelisting.retrofit.createRetrofit
import br.com.deliverymuch.storelisting.retrofit.provideOkHttpClient
import br.com.deliverymuch.storelisting.retrofit.service.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltCompanyModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return provideOkHttpClient(true)
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return createRetrofit(okHttpClient)
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}
