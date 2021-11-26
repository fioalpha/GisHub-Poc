package com.fioalpha.gists.domain.usecase

import com.fioalpha.gists.data.GistRepository
import com.fioalpha.gists.domain.model.Gist

class FetchListGistUseCaseImpl(
    private val gistRepository: GistRepository
) : FetchListGistUseCase {

    override suspend fun execute(page: Int): List<Gist> {
        return gistRepository.getGist(page)
    }
}

