package me.mqueiroz.core_network

interface ApiInfoProvider {

    fun getHost(): String

    fun getKey(): String
}