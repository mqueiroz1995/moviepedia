package me.mqueiroz.network.serverconfig.data

import com.squareup.moshi.Json

data class Language(
    @field:Json(name = "iso_639_1") val code: String,
    @field:Json(name = "name") val name: String,
    @field:Json(name = "english_name") val englishName: String
)