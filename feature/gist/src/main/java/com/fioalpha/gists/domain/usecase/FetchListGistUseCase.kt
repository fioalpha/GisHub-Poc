package com.fioalpha.gists.domain.usecase

import com.fioalpha.gists.domain.model.Gist

interface FetchListGistUseCase {
    suspend fun execute(page: Int = 0): List<Gist>
}
