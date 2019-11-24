package me.mqueiroz.network

import io.reactivex.Single
import me.mqueiroz.core_network.configuration.data.ServerConfigCache
import me.mqueiroz.core_network.configuration.data.ServerConfigRepositoryImpl
import me.mqueiroz.core_network.configuration.data.ServerConfigService
import me.mqueiroz.core_network.configuration.domain.ImagesConfig
import me.mqueiroz.core_network.configuration.domain.ServerConfig
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.quality.Strictness

class ServerConfigurationRepositoryTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS)

    @Mock
    lateinit var cache: ServerConfigCache

    @Mock
    lateinit var service: ServerConfigService

    @InjectMocks
    lateinit var repo: ServerConfigRepositoryImpl

    @Test
    fun getServerConfig_ShouldReturnCache_WhenCacheIsAvailable() {
        // given
        // TODO: improve the way data is provided
        val cacheConfig: ServerConfig = ServerConfig(
            ImagesConfig(
                baseUrl = "secure_base_url",
                posterSizes = "poster_sizes",
                backdropSizes = "backdrop_sizes",
                logoSizes = "logo_sizes",
                profileSizes = "profile_sizes",
                stillSizes = "still_sizes"
            )
        )

        // TODO: improve the way data is provided
        val serviceConfig: ServerConfig = ServerConfig(
            ImagesConfig(
                baseUrl = "server_secure_base_url",
                posterSizes = "server_poster_sizes",
                backdropSizes = "server_backdrop_sizes",
                logoSizes = "server_logo_sizes",
                profileSizes = "server_profile_sizes",
                stillSizes = "server_still_sizes"
            )
        )

        `when`(cache.get()).thenReturn(Single.just(cacheConfig))

        // when
        repo.getServerConfig()
            .test()
            .assertValue(cacheConfig)
    }

    @Test
    fun getServerConfig_ShouldReturnServiceConfig_WhenCacheIsUnavailable() {
        // given
        // TODO: improve the way data is provided
        val serviceConfig: ServerConfig = ServerConfig(
            ImagesConfig(
                baseUrl = "server_secure_base_url",
                posterSizes = "server_poster_sizes",
                backdropSizes = "server_backdrop_sizes",
                logoSizes = "server_logo_sizes",
                profileSizes = "server_profile_sizes",
                stillSizes = "server_still_sizes"
            )
        )

        `when`(cache.get()).thenReturn(Single.error(Exception()))
        `when`(service.getServerConfig()).thenReturn(Single.just(serviceConfig))

        // when
        repo.getServerConfig()
            .test()
            .assertValue(serviceConfig)
    }
}