package me.mqueiroz.home.data

import io.reactivex.Single
import io.reactivex.functions.BiFunction
import me.mqueiroz.home.domain.Image
import me.mqueiroz.home.domain.Movie
import me.mqueiroz.home.domain.TrendingRepository
import me.mqueiroz.network.serverconfig.domain.ServerConfig
import me.mqueiroz.network.serverconfig.domain.ServerConfigRepository

class TrendingRepositoryImpl(
    private val service: TrendingService,
    private val serverConfigRepository: ServerConfigRepository
) : TrendingRepository {

    override fun getTrending(mediaType: MediaType, timeWindow: TimeWindow): Single<List<Movie>> {
        return service.getTrending(mediaType, timeWindow)
            .zipWith(
                serverConfigRepository.getServerConfig(),
                BiFunction { t: TrendingResponse, idx: ServerConfig -> map(idx, t) })
    }

    private fun map(serverConfig: ServerConfig, response: TrendingResponse): List<Movie> {
        return response.results?.map { movie ->
            Movie(
                id = movie.id,
                name = movie.name,
                overview = movie.overview ?: "",
                releaseDate = movie.releaseDate ?: "",
                poster = movie.poster?.let { Image(serverConfig.imagesConfig, Image.Type.POSTER, it) },
                rate = movie.rate ?: 0f
            )
        } ?: emptyList()
    }
}