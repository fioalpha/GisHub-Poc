package com.fioalpha.gists.data.repository.datasource

import retrofit2.http.GET
import retrofit2.http.Query


interface GistRemoteDataSource {
    suspend fun fetchGists(@Query("page") page: Int): List<GistsDataSource>
}

class GistRemoteDataSourceImpl(
    private val gistService: GistService
) : GistRemoteDataSource {
    override suspend fun fetchGists(page: Int): List<GistsDataSource> {
        return gistService.fetchGists(page)
    }

}

data class GistsDataSource(
    val id: String,
    val url: String,
    val files: HashMap<String, FileDataSource>,
    val created_at: String,
    val comments: Int,
    val owner: OwnerDataSource
)

data class OwnerDataSource(
    val login: String,
    val id: Long,
    val avatar_url: String,
)
data class FileDataSource(
    val filename: String,
    val type: String,
    val language: String
)

interface GistService {
    @GET("/public")
    suspend fun fetchGists(@Query("page") page: Int): List<GistsDataSource>
}