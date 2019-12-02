package me.mqueiroz.network.serverconfig.domain

import io.reactivex.Completable

class FetchServerConfigUseCase(
    private val serverConfigRepository: ServerConfigRepository
) {

    operator fun invoke(): Completable {
        return serverConfigRepository.getServerConfig().toCompletable()
            .concatWith(serverConfigRepository.getSupportedLanguages().toCompletable())
    }
}