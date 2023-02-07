package com.example.coursesapp.data.di

import com.example.coursesapp.data.repository.ClassLocalRepositoryImpl
import com.example.coursesapp.data.repository.ClassRepository
import com.example.coursesapp.data.repository.HomeworkLocalRepositoryImpl
import com.example.coursesapp.data.repository.HomeworkRepository
import com.example.coursesapp.presentation.mapper.ClassEntityToUiModelMapper
import com.example.coursesapp.presentation.mapper.HomeworkEntityToUiModelMapper
import com.example.coursesapp.presentation.viewModel.MainViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val mainModule = module {
    single<ClassRepository> { ClassLocalRepositoryImpl() }
    single<HomeworkRepository> { HomeworkLocalRepositoryImpl() }
    factory { ClassEntityToUiModelMapper(androidApplication().resources) }
    factory { HomeworkEntityToUiModelMapper(androidApplication().resources) }
    viewModel { MainViewModel(get(), get(), get(), get()) }
}