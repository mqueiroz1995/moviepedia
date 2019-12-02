package me.mqueiroz.network.serverconfig.data

import io.reactivex.Single
import me.mqueiroz.network.serverconfig.domain.Language
import me.mqueiroz.network.serverconfig.domain.ServerConfig
import me.mqueiroz.network.serverconfig.domain.ServerConfigRepository

internal class ServerConfigRepositoryImpl(
    private val cache: ServerConfigCache,
    private val service: ServerConfigService
) : ServerConfigRepository {

    private var supportedLanguages: List<Language>? = null

    // TODO: implement cache properly
    // should we fetch all the config in a single method?
    // this would remove the FetchServerConfigUseCase
    override fun getServerConfig(): Single<ServerConfig> {
        return cache.get()
            .onErrorResumeNext {
                service.getServerConfig()
                    .doOnSuccess { cache.save(it) }
            }
    }

    override fun getSupportedLanguages(): Single<List<Language>> {
        return Single.fromCallable { supportedLanguages!! }
            .onErrorResumeNext {
                service.getSupportedLanguages()
                    .flattenAsObservable { it }
                    .map {
                        Language(
                            code = it.code,
                            name = it.name.ifEmpty { it.englishName }
                        )
                    }
                    .toList()
                    .doOnSuccess { supportedLanguages = it }
            }
    }
}