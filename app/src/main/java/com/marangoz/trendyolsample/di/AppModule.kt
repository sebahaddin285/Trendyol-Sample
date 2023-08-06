package com.marangoz.trendyolsample.di

import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.marangoz.trendyolsample.data.remote.RetrofitService
import com.marangoz.trendyolsample.data.remote.RickService
import com.marangoz.trendyolsample.data.repository.RepositoryImpl
import com.marangoz.trendyolsample.domain.repository.Repository
import com.marangoz.trendyolsample.domain.usecase.CategoryUseCase
import com.marangoz.trendyolsample.domain.usecase.ProductUseCase
import com.marangoz.trendyolsample.domain.usecase.ServiceUseCase
import com.marangoz.trendyolsample.domain.usecase.ViewPagerPhotosUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideClient(@ApplicationContext context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(ChuckerInterceptor.Builder(context).build())
            .build()

    }

    @Provides
    @Singleton

    fun provideApiService(client: OkHttpClient): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(RetrofitService::class.java)
    }

    @Provides
    @Singleton
    fun provideRickService(client: OkHttpClient): RickService {
        return Retrofit.Builder()
            .baseUrl("https://rickandmortyapi.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
            .create(RickService::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(service: RetrofitService,rickService: RickService): Repository {
        return RepositoryImpl(service,rickService)

    }

    @Provides
    @Singleton
    fun provideProductUseCase(repo : Repository): ProductUseCase {
        return ProductUseCase(repo)

    }

    @Provides
    @Singleton
    fun ServiceUseCase(repo : Repository): ServiceUseCase {
        return com.marangoz.trendyolsample.domain.usecase.ServiceUseCase(repo)

    }

    @Provides
    @Singleton
    fun viewPagerUseCase(repo : Repository): ViewPagerPhotosUseCase {
        return ViewPagerPhotosUseCase(repo)

    }
    @Provides
    @Singleton
    fun provideCategoryUseCase(repo : Repository): CategoryUseCase {
        return CategoryUseCase(repo)

    }
}