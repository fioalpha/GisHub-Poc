package com.fioalpha.restclient.di

import com.fioalpha.restclient.RestClient
import org.koin.dsl.module
import retrofit2.Retrofit

val restModuleDI = module {
    single<Retrofit> { RestClient().invoke("") }
}