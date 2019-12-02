package me.mqueiroz.home.data

import io.reactivex.Single
import io.reactivex.rxkotlin.zipWith
import me.mqueiroz.home.domain.Image
import me.mqueiroz.home.domain.Movie
import me.mqueiroz.home.domain.MoviesRepository
import me.mqueiroz.network.serverconfig.domain.ServerConfig
import me.mqueiroz.network.serverconfig.domain.ServerConfigRepository

class MoviesRepositoryImpl(
    private val service: MovieService,
    private val serverConfigRepository: ServerConfigRepository
) : MoviesRepository {

    override fun getNowPlaying(mediaType: MediaType, timeWindow: TimeWindow): Single<List<Movie>> {
        return service.getNowPlaying()
            .zipWith(serverConfigRepository.getServerConfig()) { response: MovieServiceResponse, serverConfig: ServerConfig ->
                map(serverConfig, response)
            }
    }

    private fun map(serverConfig: ServerConfig, response: MovieServiceResponse): List<Movie> {
        return response.results?.map { movie ->
            Movie(
                id = movie.id,
                title = movie.title,
                overview = movie.overview ?: "",
                releaseDate = movie.releaseDate ?: "",
                poster = movie.poster?.let { Image(serverConfig.imagesConfig, Image.Type.POSTER, it) },
                backdrop = movie.backdrop?.let { Image(serverConfig.imagesConfig, Image.Type.BACKDROP, it) },
                rate = movie.voteAverage ?: 0f
            )
        } ?: emptyList()
    }
}