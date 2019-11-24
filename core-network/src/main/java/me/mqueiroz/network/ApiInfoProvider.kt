package me.mqueiroz.network

interface ApiInfoProvider {

    fun getHost(): String

    fun getKey(): String
}