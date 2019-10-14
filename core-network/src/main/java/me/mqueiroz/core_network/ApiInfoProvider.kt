package me.mqueiroz.core_network

interface ApiInfoProvider {

    fun provideHost(): String

    fun provideKey(): String
}