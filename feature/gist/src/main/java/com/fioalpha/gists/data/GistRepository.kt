package com.fioalpha.gists.data

import com.fioalpha.gists.data.repository.datasource.GistRemoteDataSource
import com.fioalpha.gists.domain.model.File
import com.fioalpha.gists.domain.model.Gist

interface GistRepository {
    suspend fun getGist(page: Int): List<Gist>
}

class GistRepositoryImpl(
    private val gistRemoteDataSource: GistRemoteDataSource
): GistRepository {
    override suspend fun getGist(page: Int): List<Gist> {
        return gistRemoteDataSource.fetchGists(page)
            .map {
                Gist(
                    name = it.owner.login,
                    thumbnails = it.owner.avatar_url,
                    files = File("")
                )
            }
    }

}
