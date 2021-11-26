package com.fioalpha.gists.domain.usecase

import com.fioalpha.gists.data.GistRepositoryImpl
import com.fioalpha.gists.data.repository.datasource.GistRemoteDataSourceImpl
import com.fioalpha.gists.data.repository.datasource.GistService
import com.fioalpha.gists.data.repository.datasource.GistsDataSource
import com.fioalpha.gists.domain.model.File
import com.fioalpha.gists.domain.model.Gist
import com.google.gson.Gson
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@ExperimentalCoroutinesApi
@ObsoleteCoroutinesApi
class FetchListGistUseCaseTest: KoinTest {

    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    private val serviceMock: GistService = mock()

    private val userCase: FetchListGistUseCase by inject()

    @Before
    fun setup() {
        startKoin {
            modules(
                module {
                    single<FetchListGistUseCase>{
                        FetchListGistUseCaseImpl(
                            gistRepository = GistRepositoryImpl(
                                gistRemoteDataSource = GistRemoteDataSourceImpl(serviceMock)
                            )
                        )
                    }
                }
            )
        }
        Dispatchers.setMain(mainThreadSurrogate)
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
        stopKoin()
    }

    @Test
    fun `when called execute With response empty`() {

        runBlocking {
            whenever(serviceMock.fetchGists(0)).thenReturn(emptyList())
            launch(Dispatchers.Main) {
                val result = userCase.execute(0)
                assertEquals(result, emptyList<Gist>())
            }
        }
    }

    @Test
    fun `when called execute With response item`() {
        val responseMock = "{\"url\":\"https://api.github.com/gists/f29da952a0e123080447b1b490c863cf\",\"forks_url\":\"https://api.github.com/gists/f29da952a0e123080447b1b490c863cf/forks\",\"commits_url\":\"https://api.github.com/gists/f29da952a0e123080447b1b490c863cf/commits\",\"id\":\"f29da952a0e123080447b1b490c863cf\",\"node_id\":\"G_kwDOAY5TqNoAIGYyOWRhOTUyYTBlMTIzMDgwNDQ3YjFiNDkwYzg2M2Nm\",\"git_pull_url\":\"https://gist.github.com/f29da952a0e123080447b1b490c863cf.git\",\"git_push_url\":\"https://gist.github.com/f29da952a0e123080447b1b490c863cf.git\",\"html_url\":\"https://gist.github.com/f29da952a0e123080447b1b490c863cf\",\"files\":{\"ubo.js\":{\"filename\":\"ubo.js\",\"type\":\"application/javascript\",\"language\":\"JavaScript\",\"raw_url\":\"https://gist.githubusercontent.com/pundoo/f29da952a0e123080447b1b490c863cf/raw/a6c52587c57c3c619dea0ec48ae202a0ae6afcb0/ubo.js\",\"size\":1457}},\"public\":true,\"created_at\":\"2021-11-26T18:27:01Z\",\"updated_at\":\"2021-11-26T18:27:01Z\",\"description\":\"\",\"comments\":0,\"user\":null,\"comments_url\":\"https://api.github.com/gists/f29da952a0e123080447b1b490c863cf/comments\",\"owner\":{\"login\":\"pundoo\",\"id\":26104744,\"node_id\":\"MDQ6VXNlcjI2MTA0NzQ0\",\"avatar_url\":\"https://avatars.githubusercontent.com/u/26104744?v=4\",\"gravatar_id\":\"\",\"url\":\"https://api.github.com/users/pundoo\",\"html_url\":\"https://github.com/pundoo\",\"followers_url\":\"https://api.github.com/users/pundoo/followers\",\"following_url\":\"https://api.github.com/users/pundoo/following{/other_user}\",\"gists_url\":\"https://api.github.com/users/pundoo/gists{/gist_id}\",\"starred_url\":\"https://api.github.com/users/pundoo/starred{/owner}{/repo}\",\"subscriptions_url\":\"https://api.github.com/users/pundoo/subscriptions\",\"organizations_url\":\"https://api.github.com/users/pundoo/orgs\",\"repos_url\":\"https://api.github.com/users/pundoo/repos\",\"events_url\":\"https://api.github.com/users/pundoo/events{/privacy}\",\"received_events_url\":\"https://api.github.com/users/pundoo/received_events\",\"type\":\"User\",\"site_admin\":false},\"truncated\":false}"
        val mock = Gson().fromJson(responseMock, GistsDataSource::class.java)
        runBlocking {
            whenever(serviceMock.fetchGists(0)).thenReturn( listOf(mock))
            launch(Dispatchers.Main) {
                val result = userCase.execute(0)
                assertEquals(
                    result,
                    listOf(
                        Gist(
                            name = "pundoo",
                            thumbnails = "https://avatars.githubusercontent.com/u/26104744?v=4",
                            files = File("")
                        )
                    )
                )
            }
        }
    }

}