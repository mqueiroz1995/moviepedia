package me.mqueiroz.network.serverconfig.domain

import com.squareup.moshi.Json
import me.mqueiroz.network.serverconfig.domain.ImagesConfig

data class ServerConfig(
    @field:Json(name = "images") val imagesConfig: ImagesConfig
)