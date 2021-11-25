package com.fioalpha.gists.data

import com.fioalpha.gists.domain.model.Gist

interface GistRepository {
    suspend fun getGist(page: Int): List<Gist>
}
