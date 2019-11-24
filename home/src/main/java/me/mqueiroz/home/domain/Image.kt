package me.mqueiroz.home.domain

import me.mqueiroz.network.serverconfig.domain.ImagesConfig

data class Image(
    private val imagesConfig: ImagesConfig,
    private val type: Type,
    private val id: String
) {

    enum class Type {
        POSTER
    }

    val optimalSize: String
        get() {
            return imagesConfig.baseUrl + sizes.first() + id
        }

    private val sizes: List<String>
        get() {
            return when (type) {
                Type.POSTER -> imagesConfig.posterSizes
            }
        }
}