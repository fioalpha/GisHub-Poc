package com.fioalpha.gists.di

import com.fioalpha.gists.data.GistRepository
import com.fioalpha.gists.domain.model.Gist
import com.fioalpha.gists.domain.usecase.FetchListGistUseCase
import com.fioalpha.gists.domain.usecase.FetchListGistUseCaseImpl
import org.koin.dsl.module

val gistModule = module {
    single<GistRepository> {
        object : GistRepository {
            override suspend fun getGist(page: Int): List<Gist> {
                return emptyList()
            }
        }
    }
    single<FetchListGistUseCase> { FetchListGistUseCaseImpl(gistRepository = get()) }
}
