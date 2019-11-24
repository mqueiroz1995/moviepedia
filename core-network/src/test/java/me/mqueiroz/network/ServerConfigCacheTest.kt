package me.mqueiroz.network

import me.mqueiroz.network.serverconfig.data.ServerConfigCacheImpl
import me.mqueiroz.network.serverconfig.domain.ImagesConfig
import me.mqueiroz.network.serverconfig.domain.ServerConfig
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.junit.MockitoJUnit
import org.mockito.junit.MockitoRule
import org.mockito.quality.Strictness

class ServerConfigCacheTest {

    @get:Rule
    val mockitoRule: MockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS)

    @InjectMocks
    lateinit var cache: ServerConfigCacheImpl

    @Test
    fun get_ShouldReturnConfig_WhenCacheWasSaved() {
        val config = ServerConfig(
            ImagesConfig(
                baseUrl = "secure_base_url",
                posterSizes = "poster_sizes",
                backdropSizes = "backdrop_sizes",
                logoSizes = "logo_sizes",
                profileSizes = "profile_sizes",
                stillSizes = "still_sizes"
            )
        )

        cache.save(config)

        cache.get()
            .test()
            .assertValue(config)
    }

    @Test
    fun get_ShouldReturnCacheMiss_WhenCacheIsNull() {
        cache.get()
            .test()
            .assertEmpty()
//            .assertError(ServerConfigCache.CacheMissException::class.java)
    }
}